package com.miu.waa.lab3.service;

import java.util.List;

import com.miu.waa.lab3.entity.Address;

public interface AddressService {
    Address findById(Integer id);
    List<Address> findAll();
    Address create(Address address);
    Address update(Address address);
    Address delete(Integer id);
}
