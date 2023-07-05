package com.example.DBDemo.reposiroty;

import com.example.DBDemo.entity.Address;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends ListCrudRepository<Address, Long> {
}
