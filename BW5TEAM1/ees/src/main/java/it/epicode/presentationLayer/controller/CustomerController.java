package it.epicode.presentationLayer.controller;

import it.epicode.businessLayer.services.CustomerService;
import it.epicode.dataLayer.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody @Validated Customer customer) {
        Customer createdCustomer = customerService.saveCustomer(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<Customer>> getAllCustomers(Pageable pageable) {
        Page<Customer> customers = customerService.findAllCustomers(pageable);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findCustomerById(id);
        return customer.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
        Optional<Customer> customer = customerService.findCustomerById(id);
        if (customer.isPresent()) {
            Customer existingCustomer = customer.get();
            Customer updatedCustomer = Customer.builder()
                    .withRagioneSociale(customerDetails.getRagioneSociale())
                    .withPartitalva(customerDetails.getPartitalva())
                    .withEmail(customerDetails.getEmail())
                    .withDataInserimento(customerDetails.getDataInserimento())
                    .withDataUltimoContatto(customerDetails.getDataUltimoContatto())
                    .withFatturatoAnnuale(customerDetails.getFatturatoAnnuale())
                    .withPec(customerDetails.getPec())
                    .withTelefono(customerDetails.getTelefono())
                    .withEmailContatto(customerDetails.getEmailContatto())
                    .withNomeContatto(customerDetails.getNomeContatto())
                    .withCognomeContatto(customerDetails.getCognomeContatto())
                    .withTelefonoContatto(customerDetails.getTelefonoContatto())
                    .withLogo(customerDetails.getLogo())
                    .withIndirizzoLegale(customerDetails.getIndirizzoLegale())
                    .withIndirizzoOperativo(customerDetails.getIndirizzoOperativo())
                    .withTipoCliente(customerDetails.getTipoCliente())
                    .build();
            updatedCustomer = customerService.saveCustomer(updatedCustomer);
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

