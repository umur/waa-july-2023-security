package com.waa.lab3.service;

import com.waa.lab3.entity.Address;
import com.waa.lab3.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepo addressRepo;
    @Override
    public String addAddress(Address address){
        addressRepo.save(address);
        return "address added";
    }
    @Override
    public Address getById(Long id){
        Optional<Address>addr= addressRepo.findById(id);
        if(addr.isPresent())return addr.get();
        else return null;
    }
    @Override
    public List<Address> getAllBy(){
        return addressRepo.findAll();
    }
    @Override
    public String updateAddress(Long id, Address addr){
        Optional<Address>address=addressRepo.findById(id);
        if(address.isPresent()){
            Address d=address.get();
            d.setCity(addr.getCity());
            d.setId(addr.getId());
            d.setZip(addr.getZip());
            addressRepo.save(d);
        }
        return "address updated";
    }
    @Override
    public String deleteAddress(Long id){
        addressRepo.deleteById(id);
        return "address deleted";
    }
}
