package it.epicode.dataLayer.repositories;

import it.epicode.dataLayer.entities.Utenti;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtentiRepository extends JpaRepository<Utenti, Long> {
}
