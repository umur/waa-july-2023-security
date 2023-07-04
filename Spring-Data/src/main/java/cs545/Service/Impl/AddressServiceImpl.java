package cs545.Service.Impl;

import cs545.DAO.AddressRepo;
import cs545.Domain.Address;
import cs545.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepo addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(Integer id) {
        return addressRepository.findById(id).get();
    }

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Integer id, Address address) {
        Address existingAddress = addressRepository.getAddressById(id);
        existingAddress.setStreet(address.getStreet());
        existingAddress.setZip(address.getZip());
        existingAddress.setCity(address.getCity());
        return addressRepository.save(existingAddress);
    }

    @Override
    public void deleteAddress(Integer id) {
        Address address = addressRepository.getAddressById(id);
        addressRepository.delete(address);
    }
}
