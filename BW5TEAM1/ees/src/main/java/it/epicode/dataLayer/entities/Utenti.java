package it.epicode.dataLayer.entities;

import it.epicode.dataLayer.enums.TipoUtenti;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
@Table(name = "utenti")
public class Utenti extends BaseEntity{
    private String nomeUtente;
    private String email;
    private String password;
    private String nome;
    private String cognome;
    private String avatar;
    private TipoUtenti tipoUtenti;

}
