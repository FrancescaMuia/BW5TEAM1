package it.epicode.businessLayer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Builder(setterPrefix = "with")
@AllArgsConstructor
/*utilizzato per restituire le informazioni di autenticazione, come il token JWT.*/
public class LoginResponseDto extends DtoBase{
    private long id;
    private String token;
    private String username;
    private String email;
    private String nome;
    private String cognome;
    private String avatar;
    private List<String> roles;
}
