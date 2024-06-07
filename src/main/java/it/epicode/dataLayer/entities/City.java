package it.epicode.dataLayer.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "cities")
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
/*La classe City rappresenta un Comune con un nome e un riferimento alla sua provincia*/
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cities_seq")
    @SequenceGenerator(name = "cities_seq", sequenceName = "cities_seq")
    private Long id;

    private String name; // Nome del Comune

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    /*@JoinColumn(name = "province_id")*/
    private Province province; // La provincia a cui appartiene questo comune


    @OneToMany(mappedBy = "city")
    private List<Address> addresses; // Elenco degli indirizzi in questa città
}
