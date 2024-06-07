package it.epicode.dataLayer.repositories;

import it.epicode.dataLayer.entities.Customer;
import it.epicode.dataLayer.entities.InvoiceStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long>, PagingAndSortingRepository<Customer, Long> {

    Page<Customer> findBycompanyNameContaining(String ragioneSociale, Pageable pageable);

    Page<Customer> findByannualRevenueBetween(double minFatturato, double maxFatturato, Pageable pageable);

    Page<Customer> findByregistrationDateBetween(LocalDate startDate, LocalDate endDate, Pageable pageable);

    Page<Customer> findBylastContactDateBetween(LocalDate startDate, LocalDate endDate, Pageable pageable);


}
