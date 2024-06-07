package it.epicode.presentationLayer.controller;

import it.epicode.businessLayer.service.InvoiceStatusService;
import it.epicode.dataLayer.entities.InvoiceStatus;
import it.epicode.presentationLayer.model.InvoiceStatusModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/invoiceStatus")
public class InvoiceStatusController {

    @Autowired
    private InvoiceStatusService invoiceStatusService;

    @PostMapping
    private ResponseEntity<InvoiceStatus> createInvoiceStatus(@RequestBody @Validated InvoiceStatusModel model){
        var savedInvoiceStatus = invoiceStatusService.addInvoiceStatus(model.name());
        return new ResponseEntity<>(savedInvoiceStatus, HttpStatus.CREATED);
    }
}
