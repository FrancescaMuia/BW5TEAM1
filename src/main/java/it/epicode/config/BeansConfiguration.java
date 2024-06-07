package it.epicode.config;

import it.epicode.businessLayer.dto.LoginResponseDto;
import it.epicode.businessLayer.dto.RegisterUserDto;
import it.epicode.businessLayer.dto.RegisteredUserDto;
import it.epicode.businessLayer.service.Mapper;
import it.epicode.dataLayer.entities.Role;
import it.epicode.dataLayer.entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;

@Configuration
public class BeansConfiguration {
    @Bean
    @Scope("singleton")
    Mapper<RegisterUserDto, User> mapRegisterUser2UserEntity() {
        return (input) -> User.builder() //
                .withUsername(input.getUsername())
                .withEmail(input.getEmail())
                .withPassword(input.getPassword())
                .withFirstName(input.getNome())
                .withLastName(input.getCognome())
                .withAvatar(input.getAvatar())
                .withRoles(new ArrayList<>())  // Inizializza la lista dei ruoli
                .build();
    }

    @Bean
    @Scope("singleton")
    Mapper<User, RegisteredUserDto> mapUserEntity2RegisteredUser() {
        return (input) -> RegisteredUserDto.builder()
                .withId(input.getId())
                .withUsername(input.getUsername())
                .withEmail(input.getEmail())
                .withNome(input.getFirstName())
                .withCognome(input.getLastName())
                .withAvatar(input.getAvatar())
                .withRoles(input.getRoles().stream().map(Role::getName).toList())
                .build();
    }

    @Bean
    @Scope("singleton")
    Mapper<User, LoginResponseDto> mapUserEntity2LoginResponse() {
        return (input) -> LoginResponseDto.builder()
                .withUsername(input.getUsername())
                .withEmail(input.getEmail())
                .withNome(input.getFirstName())
                .withCognome(input.getLastName())
                .withAvatar(input.getAvatar())
                .withRoles(input.getRoles().stream().map(Role::getName).toList())
                .build();
    }
}
