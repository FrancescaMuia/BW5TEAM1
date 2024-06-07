package it.epicode.businessLayer.impl;

import it.epicode.businessLayer.service.InvoiceService;
import it.epicode.dataLayer.entities.Customer;
import it.epicode.dataLayer.entities.Invoice;
import it.epicode.dataLayer.entities.InvoiceStatus;
import it.epicode.dataLayer.repositories.CustomerRepository;
import it.epicode.dataLayer.repositories.InvoiceRepository;
import it.epicode.dataLayer.repositories.InvoiceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public Optional<Invoice> getInvoiceById(Long id) {
        return invoiceRepository.findById(id);
    }

    @Override
    public Invoice addInvoice(Invoice invoice) {
        Long customerId = invoice.getCustomer().getId();
        String invoiceStatusName = invoice.getStatus().getName();

        Optional<Customer> customer = customerRepository.findById(customerId);
        Optional<InvoiceStatus> status = invoiceStatusRepository.findByName(invoiceStatusName);

        if (customer.isPresent() && status.isPresent()){
            invoice.setCustomer(customer.get());
            invoice.setStatus(status.get());
            return invoiceRepository.save(invoice);
        }else {
            throw new RuntimeException("Invoice Status not found " + status);
        }
    }

    @Override
    public Invoice updateInvoice(Invoice invoice) {
        if (invoiceRepository.existsById(invoice.getId())) {
            return invoiceRepository.save(invoice);
        }
        throw new RuntimeException("Invoice not found");    }

    @Override
    public void deleteInvoice(Long id) {
        if (invoiceRepository.existsById(id)) {
            invoiceRepository.deleteById(id);
        } else {
            throw new RuntimeException("Invoice not found");
        }
    }
}
