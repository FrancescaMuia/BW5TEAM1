package it.epicode.dataLayer.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Table(name = "provinces")
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class Province extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "provinces_seq")
    @SequenceGenerator(name = "provinces_seq", sequenceName = "provinces_seq")
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 50)
    private String acronym;

    @Column(nullable = false, length = 50)
    private String region;

}
