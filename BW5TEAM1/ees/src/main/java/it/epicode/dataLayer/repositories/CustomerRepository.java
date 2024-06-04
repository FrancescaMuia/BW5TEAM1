package it.epicode.dataLayer.repositories;

import it.epicode.dataLayer.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface CustomerRepository extends JpaRepository<Customer, Long>, PagingAndSortingRepository<Customer, Long> {

    Page<Customer> findByRagioneSocialeContaining(String ragioneSociale, Pageable pageable);

    Page<Customer> findByFatturatoAnnualeBetween(double minFatturato, double maxFatturato, Pageable pageable);

    Page<Customer> findByDataInserimentoBetween(LocalDate startDate, LocalDate endDate, Pageable pageable);

    Page<Customer> findByDataUltimoContattoBetween(LocalDate startDate, LocalDate endDate, Pageable pageable);
}
