package it.epicode.dataLayer.repositories;

import it.epicode.dataLayer.entities.InvoiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InvoiceStatusRepository extends JpaRepository<InvoiceStatus, Long>, PagingAndSortingRepository<InvoiceStatus, Long> {
}
