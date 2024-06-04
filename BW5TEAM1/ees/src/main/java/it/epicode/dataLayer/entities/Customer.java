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

    @Column(nullable = false)
    private LocalDate dataInserimento;

    @Column(nullable = false)
    private LocalDate dataUltimoContatto;

    @Column(nullable = false)
    private double fatturatoAnnuale;

    @Column(length = 100)
    private String pec;

    @Column(length = 15)
    private String telefono;

    @Column(length = 100)
    private String emailContatto;

    @Column(length = 50)
    private String nomeContatto;

    @Column(length = 50)
    private String cognomeContatto;

    @Column(length = 15)
    private String telefonoContatto;

    @Column
    private String logoAziendale;

    @OneToOne
    private Address indirizzoLegale;

    @OneToOne
    private Address indirizzoOperativo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CustomerType customerType;

    @OneToMany(mappedBy = "cliente")
    private List<Invoice> fatture;
}
