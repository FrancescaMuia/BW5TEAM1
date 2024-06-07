package it.epicode.dataLayer.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "provinces")
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "provinces_seq")
    @SequenceGenerator(name = "provinces_seq", sequenceName = "provinces_seq")
    private Long id;

    private String name;
    private String acronym;
    private String region;

   /* @OneToMany(mappedBy = "province")
    private List<City> cities; // Elenco delle città in questa provincia*/
}
