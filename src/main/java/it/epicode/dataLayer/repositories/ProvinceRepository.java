package it.epicode.dataLayer.repositories;

import it.epicode.dataLayer.entities.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ProvinceRepository extends JpaRepository<Province, Long>, PagingAndSortingRepository<Province, Long> {

    Province findByRegion(String region);
    Optional<Province> findOneByAcronym(String acronym);
    Province findOneByName(String name);
    Optional<Province> findByName(String name);

}