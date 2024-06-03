package it.epicode.dataLayer.entities;

import jakarta.persistence.*;
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
    @JoinColumn(name = "azienda_id")
    private Aziende aziende;

    @ManyToOne
    @JoinColumn(name = "stato_fatture_id")
    private StatoFatture statoFatture;
}
