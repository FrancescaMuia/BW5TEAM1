package it.epicode.dataLayer.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Data
@Table(name = "invoices")
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoices_seq")
    @SequenceGenerator(name = "invoices_seq", sequenceName = "invoices_seq")
    private Long id;

    private LocalDate date;
    private Double amount;
    private String number;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer; // Il Customer a cui è associata questa Invoice

    @ManyToOne
    @JoinColumn(name = "status_id")
    private InvoiceStatus status; // Lo stato della fattura

}
