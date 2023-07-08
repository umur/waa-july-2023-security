package lab4.security.controller;

import lab4.security.dto.requests.CreateProductDTO;
import lab4.security.entity.Product;
import lab4.security.exceptions.CustomError;
import lab4.security.exceptions.RecordNotFound;
import lab4.security.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> getall(@RequestParam Map<String, String> allParams) {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isEmpty()) {
            return new ResponseEntity<>(new CustomError("Product " + id + " not found"), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(product.get());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateProductDTO createProductDTO) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("yessss"+ auth.getName());
        try {
            return ResponseEntity.ok(productService.create(createProductDTO));
        } catch (RecordNotFound e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> updatedProduct = productService.update(id, product);
        if (updatedProduct.isEmpty()) {
            return new ResponseEntity<>(new CustomError("Product " + id + " not found"), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(updatedProduct.get());
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/minPrice")
    public List<Product> getProductsByMinPrice(@RequestParam Double price) {
        return productService.getByMinPrice(price);
    }

    @GetMapping("/byKeyword")
    public List<Product> getProductsByNameContaining(@RequestParam String keyword) {
        return productService.getByKeyword(keyword);
    }

    @GetMapping("/catAndMinPrice")
    public List<Product> getProductsByCatAndLessThan(@RequestParam Long catId, @RequestParam Double price) {
        return productService.getByCategoryAndMaxPrice(catId, price);
    }

}
