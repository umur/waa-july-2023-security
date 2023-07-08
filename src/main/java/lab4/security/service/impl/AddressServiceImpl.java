package lab4.security.service.impl;

import lab4.security.entity.Address;
import lab4.security.repository.AddressRepo;
import lab4.security.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Override
    public List<Address> getAll(){
        return addressRepo.findAll();
    }

    @Override
    public Optional<Address> findById(Long id){
        return addressRepo.findById(id);
    }

    @Override
    public Address create(Address address){
        return addressRepo.save(address);
    }

    @Override
    public Optional<Address> update(Long id,Address updatedAddress){

        Optional<Address>  existingAddress = findById(id);
        if(existingAddress.isEmpty()){
            return existingAddress;
        }
        existingAddress.get().setStreet(updatedAddress.getStreet());
        existingAddress.get().setZip(updatedAddress.getZip());
        existingAddress.get().setCity(updatedAddress.getCity());
        existingAddress.get().setUser(updatedAddress.getUser());
        return Optional.of(addressRepo.save(existingAddress.get()));
    }

    @Override
    public void deleteById(Long id){
        addressRepo.deleteById(id);
    }
}