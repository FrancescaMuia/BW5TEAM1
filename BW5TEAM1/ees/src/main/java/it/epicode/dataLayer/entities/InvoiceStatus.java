package it.epicode.dataLayer.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Table(name = "invoice_status")
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceStatus extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoices_status_seq")
    @SequenceGenerator(name = "invoices_status_seq", sequenceName = "invoices_status_seq")
    private Long id;

    @Column(nullable = false, length = 50)
    private String stato;
}
