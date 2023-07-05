package com.miu.waa.lab3.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miu.waa.lab3.entity.Address;
import com.miu.waa.lab3.service.AddressService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;
    
    @PostMapping
    Address create(@RequestBody Address address) {
        return addressService.create(address);
    }

    @PutMapping("/{id}")
    Address update(@PathVariable Integer id, @RequestBody Address address) {
        address.setId(id);
        return addressService.update(address);
    }

    @DeleteMapping("/{id}")
    Address delete(@PathVariable Integer id) {
        return addressService.delete(id);
    }

    @GetMapping
    List<Address> findAll() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    Address findById(@PathVariable Integer id) {
        return addressService.findById(id);
    }
}
