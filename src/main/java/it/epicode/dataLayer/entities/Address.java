package it.epicode.dataLayer.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "addresses")
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addresses_seq")
    @SequenceGenerator(name = "addresses_seq", sequenceName = "addresses_seq")
    private Long id;

    private String street;

    private String houseNumber;

    private String locality;

    private String postalCode;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    /*Il comune al quale è associato questo Address*/
    private City city;

    @ManyToOne(optional = true)
    @JoinColumn(name = "province_id")
    private Province province; // Reference to a Province
}
