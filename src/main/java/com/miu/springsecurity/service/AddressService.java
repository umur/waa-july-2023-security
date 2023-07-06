package com.miu.springsecurity.service;

import com.miu.springsecurity.dto.AddressDto;
import com.miu.springsecurity.entity.Address;

import java.util.List;

public interface AddressService {
    void save(Address address);
    List<AddressDto> findAll();
    AddressDto findById(int id);

    void deleteById(int id);
}
