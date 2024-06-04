package it.epicode.dataLayer.repositories;

import it.epicode.dataLayer.entities.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinceRepository extends JpaRepository<Province, Long> {
    Province findByNome(String nome);
}