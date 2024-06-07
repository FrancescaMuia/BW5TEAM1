package it.epicode.businessLayer.impl;

import it.epicode.businessLayer.service.InvoiceStatusService;
import it.epicode.dataLayer.entities.InvoiceStatus;
import it.epicode.dataLayer.repositories.InvoiceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvoiceStatusServiceImpl implements InvoiceStatusService {

    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;



    @Override
    public Optional<InvoiceStatus> getInvoiceStatusById(Long id) {
        return Optional.empty();
    }

    @Override
    public InvoiceStatus addInvoiceStatus(String status) {
        var i = new InvoiceStatus();
        i.setName(status);
        invoiceStatusRepository.save(i);
        return i;
    }


    @Override
    public InvoiceStatus updateInvoiceStatus(InvoiceStatus status) {
        return null;
    }

}
