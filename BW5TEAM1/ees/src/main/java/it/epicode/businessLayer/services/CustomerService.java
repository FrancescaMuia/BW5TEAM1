package it.epicode.businessLayer.services;

import it.epicode.dataLayer.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CustomerService {

    Customer saveCustomer(Customer customer);
    Page<Customer> findAllCustomers(Pageable pageable);
    Optional<Customer> findCustomerById(Long id);
    void deleteCustomerById(Long id);
}
