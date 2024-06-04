package it.epicode.dataLayer.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Table(name = "invoices")
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class Invoice extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoices_seq")
    @SequenceGenerator(name = "invoices_seq", sequenceName = "invoices_seq")
    private Long id;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private double importo;

    @Column(nullable = false, length = 20)
    private String numero;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer cliente;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private InvoiceStatus stato;
}
