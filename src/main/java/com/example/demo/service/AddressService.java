package com.example.demo.service;

import com.example.demo.entity.Address;

import java.util.List;

public interface AddressService {
    void create(Address address);

    List<Address> findAll();

    void update(Address address);

    Address getAddress(Long id);

    void delete(Address address);
}
