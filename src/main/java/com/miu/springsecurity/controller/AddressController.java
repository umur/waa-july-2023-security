package com.miu.springsecurity.controller;

import com.miu.springsecurity.dto.AddressDto;
import com.miu.springsecurity.entity.Address;
import com.miu.springsecurity.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public List<AddressDto> findAll()
    {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public AddressDto findById(@PathVariable int id){
        return addressService.findById(id);
    }
    @PostMapping
    public void save(@RequestBody Address address){
        addressService.save(address);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Address address) {
        if (id > 0)
            address.setId(id);
        addressService.save(address);
    }

    @DeleteMapping("/{id}")
    public void deletebyId(@PathVariable int id){
        addressService.deleteById(id);
    }

}
