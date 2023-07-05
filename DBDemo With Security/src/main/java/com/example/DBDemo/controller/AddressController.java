package com.example.DBDemo.controller;

import com.example.DBDemo.entity.Address;
import com.example.DBDemo.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/addresses")
public class AddressController {

    final private AddressService addressService;

    @PostMapping
    public void saveAddress(@RequestBody Address address){
        addressService.saveAddress(address);
    }
}
