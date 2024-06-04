package it.epicode.presentationlayer.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record RegisterUserModel(
        @NotBlank @Size(max = 125) String username,
        @NotBlank @Email @Size(max = 100) String email,
        @NotBlank @Size(max = 15) String password,
        @NotBlank @Size(max = 50) String nome,
        @NotBlank @Size(max = 50) String cognome,
        @Size(max = 300) String avatar,
        String roles
) {
}
