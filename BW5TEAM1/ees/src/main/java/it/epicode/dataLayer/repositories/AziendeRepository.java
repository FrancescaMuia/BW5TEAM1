package it.epicode.dataLayer.repositories;

import it.epicode.dataLayer.entities.Clienti;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AziendeRepository extends JpaRepository<Clienti, Long> {
}
