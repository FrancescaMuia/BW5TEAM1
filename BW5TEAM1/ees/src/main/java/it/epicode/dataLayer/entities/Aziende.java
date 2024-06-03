package it.epicode.dataLayer.entities;

import it.epicode.dataLayer.enums.TipoClienti;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
@Table(name = "aziende")
public class Aziende extends BaseEntity{
    private String ragioneSociale;
    private String partitaIva;
    private String email;
    private LocalDate dataInserimento;
    private LocalDate dataUltimoContatto;
    private double fatturatoAnnuale;
    private String pec;
    private String telefono;
    private String emailContatto;
    private String nomeContatto;
    private String cognomeContatto;
    private String telefonoContatto;
    private String logoAziendale;

    @OneToMany
    private List<Indirizzi> indirizzi;
    private TipoClienti tipoClienti;

    @OneToMany(mappedBy = "aziende")
    private Fatture fatture;
}
