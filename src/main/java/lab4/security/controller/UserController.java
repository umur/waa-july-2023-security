package lab4.security.controller;

import lab4.security.entity.User;
import lab4.security.exceptions.CustomError;
import lab4.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService productService;

    @GetMapping
    public ResponseEntity<?> getall(@RequestParam Map<String, String> allParams) {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<User> product = productService.findById(id);
        if (product.isEmpty()) {
            return new ResponseEntity<>(new CustomError("User " + id + " not found"), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(product.get());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody User product) {
        return ResponseEntity.ok(productService.create(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody User product) {
        Optional<User> updatedUser = productService.update(id, product);
        if (updatedUser.isEmpty()) {
            return new ResponseEntity<>(new CustomError("User " + id + " not found"), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(updatedUser.get());
    }


}
