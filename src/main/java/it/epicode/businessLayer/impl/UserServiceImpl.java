package it.epicode.businessLayer.impl;

import it.epicode.businessLayer.dto.LoginResponseDto;
import it.epicode.businessLayer.dto.RegisterUserDto;
import it.epicode.businessLayer.dto.RegisteredUserDto;
import it.epicode.businessLayer.exceptions.InvalidLoginException;
import it.epicode.businessLayer.exceptions.PersistEntityException;
import it.epicode.businessLayer.service.Mapper;
import it.epicode.businessLayer.service.UserService;
import it.epicode.config.JwtUtils;
import it.epicode.dataLayer.entities.Role;
import it.epicode.dataLayer.entities.User;
import it.epicode.dataLayer.repositories.RolesRepository;
import it.epicode.dataLayer.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@Slf4j
/*questo service è un'implementazione dello UserService che fornisce metodi per la registrazione,
 login e recupero delle informazioni di un utente. */
public class UserServiceImpl implements UserService {
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UserRepository users;
    @Autowired
    private RolesRepository roles;

    @Autowired
    private AuthenticationManager auth;

    @Autowired
    private JwtUtils jwt;

    @Autowired
    Mapper<RegisterUserDto, User> mapEntity;
    @Autowired
    Mapper<User, RegisteredUserDto> mapRegisteredUser;
    @Autowired
    Mapper<User, LoginResponseDto> mapLogin;


    @Override
    public RegisteredUserDto register(RegisterUserDto user) {
        try {
            var u = mapEntity.map(user);
            var p = encoder.encode(user.getPassword());
            log.info("Password encrypted: {}", p);
            u.setPassword(p);
            // Inizializza la lista dei ruoli se non lo è già
            if (u.getRoles() == null) {
                u.setRoles(new ArrayList<>());
            }

            if (user.getRoles() != null) {
                Stream.of(user.getRoles().split(",")).forEach(r -> {
                    // Cerca il ruolo nel database con lo stesso nome
                    Role role = roles.findOneByName(r).orElse(null);
                    if (role != null) {
                        // Se il ruolo esiste già, lo aggiunge all'utente
                        u.getRoles().add(role);
                    } else {
                        throw new PersistEntityException(user);
                    }
                });
            }
            return mapRegisteredUser.map(users.save(u));
        } catch (Exception e) {
            log.error(String.format("Exception saving user %s", user), e);
            throw new PersistEntityException(user);
        }
    }

    @Override
    public Optional<LoginResponseDto> login(String username, String password) {
        try {
            var a = auth.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            a.getAuthorities();
            SecurityContextHolder.getContext().setAuthentication(a);

            var dto = mapLogin.map(users.findOneByUsername(username).orElseThrow());
            dto.setToken(jwt.generateToken(a));
            return Optional.of(dto);
        } catch (NoSuchElementException e) {
            log.error("User not found", e);
            throw new InvalidLoginException(username, password);
        } catch (AuthenticationException e) {
            log.error("Authentication failed", e);
            throw new InvalidLoginException(username, password);
        }
    }

    @Override
    public Optional<RegisteredUserDto> get(long id) {
        try {
            return Optional.of(mapRegisteredUser.map(users.findById(id).orElseThrow()));
        } catch (Exception e) {
            log.error(String.format("User not found for id %s", id), e);
            return Optional.empty();
        }
    }
}
