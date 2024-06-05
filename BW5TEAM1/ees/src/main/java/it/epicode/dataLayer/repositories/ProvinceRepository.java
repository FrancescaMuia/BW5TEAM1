package it.epicode.dataLayer.repositories;

import it.epicode.dataLayer.entities.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {
    Province findByNome(String nome);
}
