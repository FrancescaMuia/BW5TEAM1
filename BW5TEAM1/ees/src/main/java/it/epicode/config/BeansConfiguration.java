package it.epicode.config;

import it.epicode.businessLayer.services.Mapper;
import it.epicode.businessLayer.services.dto.LoginResponseDto;
import it.epicode.businessLayer.services.dto.RegisterUtenteDto;
import it.epicode.businessLayer.services.dto.RegisteredUtenteDto;
import it.epicode.dataLayer.entities.Utenti;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class BeansConfiguration {
	@Bean
	@Scope("singleton")
	Mapper<RegisterUtenteDto, Utenti> mapRegisterUser2UserEntity() {
		return (input) -> Utenti.builder() //
				.withNomeUtente(input.getNomeUtente()) //
				.withPassword(input.getPassword()) //
				.withEmail(input.getEmail()) //
				.build();
	}

	@Bean
	@Scope("singleton")
	Mapper<Utenti, RegisteredUtenteDto> mapUserEntity2RegisteredUser() {
		return (input) -> RegisteredUtenteDto.builder() //
				.withNomeUtente(input.getNomeUtente()) //
				.withId(input.getId()) //
				.withEmail(input.getEmail()) //
				.withRoles(input.getRoles().stream().map(r -> r.getName()).toString()) //
				.build();
	}
	
	@Bean
	@Scope("singleton")
	Mapper<Utenti, LoginResponseDto> mapUserEntity2LoginResponse() {
		return (input) -> LoginResponseDto.builder() //
				.withNomeUtente(input.getNomeUtente()) //
				.withId(input.getId()) //
				.withEmail(input.getEmail()) //
				.withRoles(input.getRoles().stream().map(r -> r.getName()).toString()) //
				.build();
	}
}
