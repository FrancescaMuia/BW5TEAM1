package it.epicode.businessLayer.service;

import it.epicode.dataLayer.entities.Invoice;


import java.util.List;
import java.util.Optional;

public interface InvoiceService {
    List<Invoice> getAllInvoices();
    Optional<Invoice> getInvoiceById(Long id);
    Invoice addInvoice(Invoice invoice);
    Invoice updateInvoice(Invoice invoice);
    void deleteInvoice(Long id);
}
