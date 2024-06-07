package it.epicode.businessLayer.service;

import it.epicode.dataLayer.entities.InvoiceStatus;


import java.util.Optional;

public interface InvoiceStatusService {
    Optional<InvoiceStatus> getInvoiceStatusById(Long id);
    InvoiceStatus addInvoiceStatus(String status);



    InvoiceStatus updateInvoiceStatus(InvoiceStatus status);

}
