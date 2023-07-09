package Demo1.demo.controller;

import Demo1.demo.entity.Address;
import Demo1.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/address")
@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;


    @PostMapping("/add")
    public void addAddress(@RequestBody Address address) {
        addressService.addAddress(address);
    }


    @PutMapping("/update")
    public String updateAddress(Long Id, @RequestBody Address address) {
        addressService.updateAddress(address, Id) ;
            return "Address updated";
        }

        @DeleteMapping("/delete")
    public void deleteAddress(Long Id, @RequestBody Address address) {
        addressService.deleteAddress(address, Id) ;
        }

        @GetMapping("/all")
    public void findAllAddress() {
        addressService.getAllAddresses();
        }

}