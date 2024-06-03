package it.epicode.businessLayer.services;

import it.epicode.businessLayer.services.dto.LoginResponseDto;
import it.epicode.businessLayer.services.dto.RegisterUtenteDto;
import it.epicode.businessLayer.services.dto.RegisteredUtenteDto;

import java.util.Optional;

public interface UtenteService {

    RegisteredUtenteDto register(RegisterUtenteDto utenti);

    Optional<LoginResponseDto> login(String nomeUtente, String password);

    Optional<RegisteredUtenteDto> get(long id);
}