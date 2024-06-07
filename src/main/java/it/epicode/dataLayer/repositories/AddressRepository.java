package it.epicode.dataLayer.repositories;

import it.epicode.dataLayer.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressRepository extends JpaRepository<Address, Long>, PagingAndSortingRepository<Address, Long> {
}