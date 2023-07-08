package lab4.security.controller;

import lab4.security.entity.Address;
import lab4.security.exceptions.CustomError;
import lab4.security.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(addressService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id) {
        Optional<Address> address = addressService.findById(id);
        if (address.isPresent()) {
            return ResponseEntity.ok(address.get());
        }
        return new ResponseEntity<>(new CustomError("Address " + id + " not found"), HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Address address) {
        return ResponseEntity.ok(addressService.create(address));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Address address) {
        return ResponseEntity.ok(addressService.update(id,address));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long addressId) {
        addressService.deleteById(addressId);
    }
}

