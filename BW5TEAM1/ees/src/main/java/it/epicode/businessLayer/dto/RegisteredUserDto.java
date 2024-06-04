package it.epicode.businessLayer.dto;


import lombok.Builder;
import lombok.Data;


import java.util.List;


@Data
/*utilizzato per restituire le informazioni dell'utente appena registrato.*/
public class RegisteredUserDto {

    private Long id;
    private String username;
    private String email;
    private String nome;
    private String cognome;
    private String avatar;
    private List<String> roles;

    @Builder(setterPrefix = "with")
    public RegisteredUserDto(Long id, String username, String email, String nome,
                             String cognome, String avatar, List<String> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
        this.avatar = avatar;
        this.roles = roles;
    }
}
