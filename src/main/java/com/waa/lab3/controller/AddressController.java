package com.waa.lab3.controller;

import com.waa.lab3.entity.Address;
import com.waa.lab3.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;
    @PostMapping("addresses")
    public String addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }
    @GetMapping("addresses/{id}")
    public Address getById(@PathVariable Long id){
       return addressService.getById(id);
    }
    @GetMapping("addresses")
    public List<Address> getAllBy(){
        return addressService.getAllBy();
    }
    @PutMapping("addresses/{id}")
    public String updateAddress(@PathVariable Long id, @RequestBody Address addr){
        return addressService.updateAddress(id,addr);
    }
    @DeleteMapping("addresses/{id}")
    public String deleteAddress(@PathVariable Long id){
        return addressService.deleteAddress(id);
    }
}
