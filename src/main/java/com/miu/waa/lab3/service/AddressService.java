package com.miu.waa.lab3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.miu.waa.lab3.entity.Address;
import com.miu.waa.lab3.repo.AddressRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepo addressRepo;

    public Address findById(Integer id) {
        Optional<Address> optionalAddress = addressRepo.findById(id);

        if (!optionalAddress.isPresent()) {
            throw new RuntimeException("Address is not found.");
        }

        return optionalAddress.get();
    }

    public List<Address> findAll() {
        return addressRepo.findAll();
    }

    public Address create(Address address) {
        return addressRepo.save(address);
    }

    public Address update(Address address) {
        Address tempAddress = findById(address.getId());

        tempAddress.setCity(address.getCity());
        tempAddress.setStreet(address.getStreet());
        tempAddress.setZip(address.getZip());

        return addressRepo.save(tempAddress);
    }

    public Address delete(Integer id) {
        Address tempAddress = findById(id);
        addressRepo.delete(tempAddress);

        return tempAddress;
    }
}
