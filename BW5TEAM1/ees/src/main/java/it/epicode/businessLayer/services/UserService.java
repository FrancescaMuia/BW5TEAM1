package it.epicode.businessLayer.services;

import it.epicode.businessLayer.dto.LoginResponseDto;
import it.epicode.businessLayer.dto.RegisterUserDto;
import it.epicode.businessLayer.dto.RegisteredUserDto;

import java.util.Optional;

public interface UserService {
    RegisteredUserDto register(RegisterUserDto user);

    Optional<LoginResponseDto> login(String username, String password);

    Optional<RegisteredUserDto> get(long id);
}
