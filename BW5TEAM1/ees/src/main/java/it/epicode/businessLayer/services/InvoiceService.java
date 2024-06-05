package it.epicode.businessLayer.services;

import it.epicode.dataLayer.entities.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface InvoiceService {
    Invoice saveInvoice(Invoice invoice);
    Page<Invoice> findAllInvoices(Pageable pageable);
    Optional<Invoice> findInvoiceById(Long id);
    void deleteInvoiceById(Long id);
}
