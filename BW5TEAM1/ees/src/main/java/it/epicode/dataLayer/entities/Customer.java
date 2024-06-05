package it.epicode.dataLayer.entities;

import com.fasterxml.jackson.databind.ser.Serializers;
import it.epicode.dataLayer.entities.enums.CustomerType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Table(name = "customers")
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customers_seq")
    @SequenceGenerator(name = "customers_seq", sequenceName = "customers_seq")
    private Long id;

    @Column(nullable = false, length = 100)
    private String ragioneSociale;

    @Column(nullable = false, length = 11)
    private String partitalva;

    @Column(nullable = false, length = 100)
    private String email;

    @Temporal(TemporalType.DATE)
    private LocalDate dataInserimento;

    @Temporal(TemporalType.DATE)
    private LocalDate dataUltimoContatto;


    @Column(nullable = false, length = 100)
    private double fatturatoAnnuale;

    @Column(nullable = false, length = 100)
    private String pec;

    @Column(nullable = false, length = 15)
    private String telefono;

    @Column(nullable = false, length = 100)
    private String emailContatto;

    @Column(nullable = false, length = 50)
    private String nomeContatto;

    @Column(nullable = false, length = 50)
    private String cognomeContatto;

    @Column(nullable = false, length = 15)
    private String telefonoContatto;

    @Column(length = 300)
    private String logo;

    @OneToMany
    private List<Invoice> invoices;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "indirizzo_legale_id", referencedColumnName = "id")
    private Address indirizzoLegale;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "indirizzo_operativo_id", referencedColumnName = "id")
    private Address indirizzoOperativo;

    @Enumerated(EnumType.STRING)
    private CustomerType tipoCliente;
}
