package Demo1.demo.service;

import Demo1.demo.entity.Address;

public interface AddressService {

    void addAddress(Address address);

    void updateAddress(Address address, Long addressId);

    void deleteAddress(Address address, Long addressId);

    abstract void getAllAddresses();
}
