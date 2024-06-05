package it.epicode.dataLayer.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Table(name = "addresses")
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class Address extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addresses_seq")
    @SequenceGenerator(name = "addresses_seq", sequenceName = "addresses_seq")
    private Long id;

    @Column(nullable = false, length = 100)
    private String via;

    @Column(nullable = false, length = 10)
    private String civico;

    @Column(nullable = false, length = 100)
    private String localita;

    @Column(nullable = false, length = 5)
    private String cap;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private City comune;
}
