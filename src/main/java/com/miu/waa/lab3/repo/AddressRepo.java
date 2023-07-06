package com.miu.waa.lab3.repo;

import org.springframework.data.repository.ListCrudRepository;

import com.miu.waa.lab3.entity.Address;

public interface AddressRepo extends ListCrudRepository<Address, Integer> {
    
}
