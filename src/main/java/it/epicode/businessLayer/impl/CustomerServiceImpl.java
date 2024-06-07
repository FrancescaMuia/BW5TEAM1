package it.epicode.businessLayer.impl;

import it.epicode.businessLayer.service.CustomerService;
import it.epicode.dataLayer.entities.Address;
import it.epicode.dataLayer.entities.City;
import it.epicode.dataLayer.entities.Customer;
import it.epicode.dataLayer.entities.Province;
import it.epicode.dataLayer.repositories.AddressRepository;
import it.epicode.dataLayer.repositories.CityRepository;
import it.epicode.dataLayer.repositories.CustomerRepository;
import it.epicode.dataLayer.repositories.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        // Save legal and operational addresses first
        if (customer.getLegalAddress() != null) {
            processAddress(customer.getLegalAddress());
        }
        if (customer.getOperationalAddress() != null) {
            processAddress(customer.getOperationalAddress());
        }
        return customerRepository.save(customer);
    }

    private void processAddress(Address address) {
        if (address.getCity() != null) {
            String cityName = address.getCity().getName();
            Optional<City> cityOpt = cityRepository.findByName(cityName);
            if (cityOpt.isPresent()) {
                address.setCity(cityOpt.get());
            } else {
                throw new RuntimeException("City not found: " + cityName);
            }
        }
        if (address.getProvince() != null) {
            String provinceName = address.getProvince().getName();
            Optional<Province> provinceOpt = provinceRepository.findByName(provinceName);
            if (provinceOpt.isPresent()) {
                address.setProvince(provinceOpt.get());
            } else {
                throw new RuntimeException("Province not found: " + provinceName);
            }
        }
        addressRepository.save(address);
    }

    @Override
    public Page<Customer> findAllCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Optional<Customer> findCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }




}
