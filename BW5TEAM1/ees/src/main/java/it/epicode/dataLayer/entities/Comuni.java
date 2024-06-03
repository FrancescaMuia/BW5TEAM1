package it.epicode.dataLayer.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Comuni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "provincia_id")
    private Province provincia;
}
