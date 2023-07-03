package com.example.demo.controller;

import com.example.demo.entity.Address;
import com.example.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping
    public void create(@RequestBody Address address) {
        addressService.create(address);
    }

    @GetMapping
    public List<Address> getAll() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable Long id) {
        return addressService.getAddress(id);
    }

    @PutMapping
    public void update(@RequestBody Address address) {
        addressService.update(address);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Address address = addressService.getAddress(id);
        addressService.delete(address);
    }
}