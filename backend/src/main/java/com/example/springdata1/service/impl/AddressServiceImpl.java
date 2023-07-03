package com.example.springdata1.service.impl;

import com.example.springdata1.entity.Address;
import com.example.springdata1.repository.AddressRepository;
import com.example.springdata1.service.AddressService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@AllArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid address id: " + id));
    }

    @Override
    public Address add(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Address address) {
        Address existingAddress = addressRepository.findById(address.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid address id: " + address.getId()));
        existingAddress.setCity(address.getCity());
        existingAddress.setZip(address.getZip());

        Address updatedAddress = addressRepository.save(existingAddress);
        return updatedAddress;
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
