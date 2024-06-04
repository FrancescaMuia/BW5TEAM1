package it.epicode.dataLayer.repositories;

import it.epicode.dataLayer.entities.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>, PagingAndSortingRepository<Invoice, Long> {

    @Query("SELECT i FROM Invoice i WHERE i.cliente.id = :clienteId")
    Page<Invoice> findByClienteId(@Param("clienteId") Long clienteId, Pageable pageable);

    @Query("SELECT i FROM Invoice i WHERE i.stato.id = :statoId")
    Page<Invoice> findByStatoId(@Param("statoId") Long statoId, Pageable pageable);

    @Query("SELECT i FROM Invoice i WHERE YEAR(i.data) = :anno")
    Page<Invoice> findByAnno(@Param("anno") int anno, Pageable pageable);

    Page<Invoice> findByImportoBetween(double minImporto, double maxImporto, Pageable pageable);
}
