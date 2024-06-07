package it.epicode.dataLayer.entities;


import it.epicode.dataLayer.entities.enums.CustomerType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@Table(name = "customers")
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customers_seq")
    @SequenceGenerator(name = "customers_seq", sequenceName = "customers_seq")
    private Long id;

    private String companyName;
    private String vatNumber;
    private String email;

    @Temporal(TemporalType.DATE)
    private LocalDate registrationDate;

    @Temporal(TemporalType.DATE)
    private LocalDate lastContactDate;

    private Double annualRevenue;
    private String pec;
    private String phone;
    private String contactEmail;
    private String contactFirstName;
    private String contactLastName;
    private String contactPhone;
    private String logo;

    @Enumerated(EnumType.STRING)
    private CustomerType type; // Enum del Customer (e.g., PA, SAS, SPA, SRL)

    @OneToMany(mappedBy = "customer")
    private List<Invoice> invoices; //  Elenco delle fatture per il cliente

    @ManyToOne
    @JoinColumn(name = "legal_address_id")
    private Address legalAddress; // Indirizzo legale del cliente

    @ManyToOne
    @JoinColumn(name = "operational_address_id")
    private Address operationalAddress; // Indirizzo operativo del cliente
}
