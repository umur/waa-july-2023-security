package com.waa.lab3.repository;

import com.waa.lab3.entity.Address;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends ListCrudRepository<Address,Long> {
}
