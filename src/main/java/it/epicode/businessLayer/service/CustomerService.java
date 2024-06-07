package it.epicode.businessLayer.service;

import it.epicode.dataLayer.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer saveCustomer(Customer customer);
    Page<Customer> findAllCustomers(Pageable pageable);
    Optional<Customer> findCustomerById(Long id);
    void deleteCustomerById(Long id);



}
