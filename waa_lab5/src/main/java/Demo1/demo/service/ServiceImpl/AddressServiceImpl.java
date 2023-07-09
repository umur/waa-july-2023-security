package Demo1.demo.service.ServiceImpl;

import Demo1.demo.entity.Address;
import Demo1.demo.repository.AddressRepository;
import Demo1.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Override
    public void addAddress(Address address) {
        addressRepository.save(address);

    }

    @Override
    public void updateAddress(Address address, Long addressId) {
        addressRepository.findById(addressId).map(address1 -> {
            address1.setCity(address.getCity());
            address1.setStreet(address.getStreet());
            address1.setZip(address.getZip());
            return addressRepository.save(address1);
        });

    }

    @Override
    public void deleteAddress(Address address, Long addressId) {
        addressRepository.deleteAll();

    }

    @Override
    public void getAllAddresses() {
        addressRepository.findAll();
    }
}
