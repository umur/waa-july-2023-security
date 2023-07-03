package com.example.springdata1.service;

import com.example.springdata1.entity.Address;

import java.util.List;


public interface AddressService {
    List<Address> findAll();

    Address findById(Long id);

    Address add(Address address);

    Address update(Address address);

    void delete(Long id);

}
