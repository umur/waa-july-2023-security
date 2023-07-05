package cs545.Service;

import cs545.Domain.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddresses();
    Address getAddressById(Integer id);
    Address createAddress(Address address);
    Address updateAddress(Integer id, Address address);
    void deleteAddress(Integer id);
}
