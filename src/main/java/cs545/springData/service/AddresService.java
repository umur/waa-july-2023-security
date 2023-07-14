package cs545.springData.service;

import cs545.springData.entity.Address;

import java.util.List;

public interface AddresService {
    public List<Address> getAddress();
    public String addAddress(Address address );
    public Address updateAddress(Long id,Address address);
    public Address getById(Long id);
    public String DeleteById(Long id);
}
