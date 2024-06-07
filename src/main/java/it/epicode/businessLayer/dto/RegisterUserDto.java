package it.epicode.businessLayer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Builder(setterPrefix = "with")
@AllArgsConstructor
/* utilizzato per raccogliere i dati di registrazione di un nuovo utente*/
public class RegisterUserDto extends DtoBase{

    private String username;
    private String email;
    private String password;
    private String nome;
    private String cognome;
    private String avatar;
    private String roles;
}
