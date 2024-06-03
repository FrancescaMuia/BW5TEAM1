package it.epicode.dataLayer.repositories;

import it.epicode.dataLayer.entities.Aziende;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AziendeRepository extends JpaRepository<Aziende, Long> {
}
