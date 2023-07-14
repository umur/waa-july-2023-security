package com.waa.lab3.service;

import com.waa.lab3.entity.Address;

import java.util.List;

public interface AddressService {
    String addAddress(Address address);

    Address getById(Long id);

    List<Address> getAllBy();

    String updateAddress(Long id, Address addr);

    String deleteAddress(Long id);
}
