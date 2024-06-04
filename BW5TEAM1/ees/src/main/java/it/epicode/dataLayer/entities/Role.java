package it.epicode.dataLayer.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "roles")
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
/*  questa classe definisce un'entità JPA per rappresentare i
 ruoli degli utenti nel sistema, inclusa la loro relazione con gli utenti stessi.*/
public class Role extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_seq")
    @SequenceGenerator(name = "roles_seq", sequenceName = "roles_seq")
    private long id;


    @Column(length = 15, unique = true)
    private String name;

    /*lista di utenti associati a questo ruolo. È definito come final per garantire
 che non possa essere riassegnato una volta inizializzato.*/
    @ManyToMany(mappedBy = "roles")
    private final List<User> usersRole = new ArrayList<>();
}
