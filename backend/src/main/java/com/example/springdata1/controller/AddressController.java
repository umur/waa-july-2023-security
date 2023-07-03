package com.example.springdata1.controller;

import com.example.springdata1.entity.Address;
import com.example.springdata1.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> add(@RequestBody Address address) {

        Address createdAddress = addressService.add(address);
        return new ResponseEntity<>(createdAddress, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getById(@PathVariable Long id) {
        Address address = addressService.findById(id);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAll() {
        List<Address> addresses = addressService.findAll();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable Long id, @RequestBody Address address) {
        if (id != address.getId()) {
            throw new IllegalArgumentException("Id does not match address id");
        }
        addressService.update(address);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        addressService.delete(id);
    }
}
