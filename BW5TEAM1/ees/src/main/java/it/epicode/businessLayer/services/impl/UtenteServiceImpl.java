package it.epicode.businessLayer.services.impl;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

import it.epicode.businessLayer.services.Mapper;
import it.epicode.businessLayer.services.UtenteService;
import it.epicode.businessLayer.services.dto.LoginResponseDto;
import it.epicode.businessLayer.services.dto.RegisterUtenteDto;
import it.epicode.businessLayer.services.dto.RegisteredUtenteDto;
import it.epicode.businessLayer.services.exceptions.InvalidLoginException;
import it.epicode.businessLayer.services.exceptions.PersistEntityException;
import it.epicode.config.JwtUtils;
import it.epicode.dataLayer.entities.RoleEntity;
import it.epicode.dataLayer.entities.Utenti;
import it.epicode.dataLayer.repositories.RolesRepository;
import it.epicode.dataLayer.repositories.UtentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	UtentiRepository utente;

	@Autowired
	private AuthenticationManager auth;

	@Autowired
	private JwtUtils jwt;

	@Autowired
	RolesRepository roles;

	@Autowired
	Mapper<RegisterUtenteDto, Utenti> mapEntity;
	@Autowired
	Mapper<Utenti, RegisteredUtenteDto> mapRegisteredutenti;
	@Autowired
	Mapper<Utenti, LoginResponseDto> mapLogin;


	@Override
	public RegisteredUtenteDto register(RegisterUtenteDto utenti) {
		try {
			var u = mapEntity.map(utenti);
			var p = encoder.encode(utenti.getPassword());
			log.info("Password encrypted: {}", p);
			u.setPassword(p);
			if (utenti.getRoles() != null)
				Stream.of(utenti.getRoles().split(",")).forEach(r -> u.getRoles().add(roles.findOneByName(r) //
						.orElse(roles.save(RoleEntity.builder().withName(r).build()))));
			return mapRegisteredutenti.map(utente.save(u));
		} catch (Exception e) {
			log.error(String.format("Exception saving utenti %s", utenti), e);
			throw new PersistEntityException(utenti);
		}
	}

	@Override
	public Optional<LoginResponseDto> login(String nomeutenti, String password) {
		try {
			var a = auth.authenticate(new UsernamePasswordAuthenticationToken(nomeutenti, password));
			a.getAuthorities();
			SecurityContextHolder.getContext().setAuthentication(a);

			var dto = mapLogin.map(utente.findOneByUsername(nomeutenti).orElseThrow());
			dto.setToken(jwt.generateToken(a));
			return Optional.of(dto);
		} catch (NoSuchElementException e) {
			log.error("utenti not found", e);
			throw new InvalidLoginException(nomeutenti, password);
		} catch (AuthenticationException e) {
			log.error("Authentication failed", e);
			throw new InvalidLoginException(nomeutenti, password);
		}
	}

	@Override
	public Optional<RegisteredUtenteDto> get(long id) {
		try {
			return Optional.of(mapRegisteredutenti.map(utente.findById(id).orElseThrow()));
		} catch (Exception e) {
			log.error(String.format("utenti not found for id %s", id), e);
			return Optional.empty();
		}
	}

}
