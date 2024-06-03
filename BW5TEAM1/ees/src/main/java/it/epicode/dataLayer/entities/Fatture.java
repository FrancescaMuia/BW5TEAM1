package it.epicode.dataLayer.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
@Table(name = "fatture")
public class Fatture extends BaseEntity{
    private LocalDate data;
    private double importo;
    private int numero;
    @ManyToOne
    private Clienti aziende;
    private StatoFatture statoFatture;
}
