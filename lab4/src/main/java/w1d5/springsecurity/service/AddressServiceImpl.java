package w1d5.springsecurity.service;

import org.springframework.stereotype.Service;
import w1d5.springsecurity.entity.Address;
import w1d5.springsecurity.repository.AddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address update(Long id, Address address) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isPresent()){
            optionalAddress.get().setStreet(address.getStreet());
            optionalAddress.get().setZip(address.getZip());
            optionalAddress.get().setCity(address.getCity());
        }
        return optionalAddress.orElse(null);
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
