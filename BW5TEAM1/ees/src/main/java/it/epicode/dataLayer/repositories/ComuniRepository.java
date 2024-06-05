package it.epicode.dataLayer.repositories;

import it.epicode.dataLayer.entities.Comuni;
import it.epicode.dataLayer.entities.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComuniRepository extends JpaRepository<Comuni, Long> {
    Comuni findByNome(String nome);
}
