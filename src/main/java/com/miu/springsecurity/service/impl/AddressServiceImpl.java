package com.miu.springsecurity.service.impl;

import com.miu.springsecurity.aspect.annotation.ExecutionTime;
import com.miu.springsecurity.dto.AddressDto;
import com.miu.springsecurity.entity.Address;
import com.miu.springsecurity.repository.AddressRepo;
import com.miu.springsecurity.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AddressServiceImpl implements AddressService {
    private  final AddressRepo addressRepo;
    private final ModelMapper modelMapper;
    @Override
    @ExecutionTime
    public void save(Address address) {
    addressRepo.save(address);
    }

    @Override
    @ExecutionTime
    public List<AddressDto> findAll() {
        var addressList= (List<Address>)addressRepo.findAll();
        return addressList.stream().map(address -> modelMapper.map(address, AddressDto.class)).toList();
    }

    @Override
    @ExecutionTime
    public AddressDto findById(int id) {
        return modelMapper.map(addressRepo.findById(id).get(),AddressDto.class);
    }

    @Override
    @ExecutionTime
    public void deleteById(int id) {
    addressRepo.deleteById(id);
    }
}
