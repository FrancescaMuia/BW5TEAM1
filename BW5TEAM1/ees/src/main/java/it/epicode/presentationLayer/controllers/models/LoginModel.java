package it.epicode.presentationLayer.controllers.models;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record LoginModel(
        @NotBlank @Length(max = 125) String nomeUtente, //
        @NotBlank @Length(max = 15) String password) {

}