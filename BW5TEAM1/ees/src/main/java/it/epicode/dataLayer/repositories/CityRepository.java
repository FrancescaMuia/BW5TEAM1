package it.epicode.dataLayer.repositories;

import it.epicode.dataLayer.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepository extends JpaRepository<City, Long>, PagingAndSortingRepository<City, Long> {
}
