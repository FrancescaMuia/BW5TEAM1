package it.epicode.businessLayer.service;

import it.epicode.dataLayer.entities.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<Address> getAllAddresses();
    Optional<Address> getAddressById(Long id);
    Address addAddress(Address address);
    Address updateAddress(Address address);
    void deleteAddress(Long id);
}
