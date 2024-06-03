package it.epicode.dataLayer.repositories;

import it.epicode.dataLayer.entities.Utenti;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtentiRepository extends JpaRepository<Utenti, Long> {

    Optional<Utenti> findOneByUsernameAndPassword(String nomeUtente, String password);
    Optional<Utenti> findOneByUsername(String nomeUtente);
}
