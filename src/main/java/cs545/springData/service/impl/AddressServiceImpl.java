package cs545.springData.service.impl;

import cs545.springData.entity.Address;
import cs545.springData.repository.AddressRepo;
import cs545.springData.service.AddresService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddresService {
    private final AddressRepo addressRepo;
    @Override
    public List<Address> getAddress(){
        return addressRepo.findAll();
    }
    @Override
   public String addAddress(Address address ){
       addressRepo.save(address);
       return "Address added";
   }
    @Override
   public Address updateAddress(Long id,Address address){
        Optional<Address> add = addressRepo.findById(id);
        if(add.isPresent()){

            add.get().setStreet(address.getStreet());
            add.get().setZip(address.getZip());
            add.get().setCity(address.getCity());
            add.get().setUser(address.getUser());

            addressRepo.save(add.get());
        }
        return add.get();

   }
    @Override
    public Address getById(Long id){
        Optional<Address> address= addressRepo.findById(id);
        if(address.isPresent()) {
            return address.get();
        }else
            return null;
    }
    @Override
    public String DeleteById(Long id){
        Optional<Address> address= addressRepo.findById(id);
        if(address.isPresent()){
            addressRepo.deleteById(id);
        }
        return"Address deleted";
    }
}
