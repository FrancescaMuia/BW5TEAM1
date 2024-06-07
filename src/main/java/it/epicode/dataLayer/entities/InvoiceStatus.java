package it.epicode.dataLayer.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table(name = "invoice_status")
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoices_status_seq")
    @SequenceGenerator(name = "invoices_status_seq", sequenceName = "invoices_status_seq")
    private Long id;

    private String name; // Name of the invoice status

    @OneToMany(mappedBy = "status")
    private List<Invoice> invoices = new ArrayList<>(); // Fatture associate a questo stato fattura
}
