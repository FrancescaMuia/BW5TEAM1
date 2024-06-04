package it.epicode.presentationlayer.model;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/*Un record in Java è una classe compatta e immutabile che rappresenta un semplice contenitore di dati.
 I record sono ideali per rappresentare DTO (Data Transfer Object) o modelli simili.
record LoginModel utilizzato per rappresentare i dati di login di un utente*/
public record LoginModel(
        @NotBlank @Length(max = 125) String username, //
        @NotBlank @Length(max = 15) String password
) {
}
