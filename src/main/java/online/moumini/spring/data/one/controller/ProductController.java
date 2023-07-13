package online.moumini.spring.data.one.controller;

import online.moumini.spring.data.one.model.Product;
import online.moumini.spring.data.one.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Iterable<Product> getAllProducts() {
        return productService.getAllProducts();
    }

     @GetMapping("/filter")
    public Iterable<Product> getAllByPriceLessThanAndCategory(@RequestParam double maxPrice, Long category_id) {
        return productService.getAllByPriceLessThanAndCategory(maxPrice, category_id);
    }

    @GetMapping("/filterB")
    public Iterable<Product> getAllProductsByPriceGreaterThan(@RequestParam double minPrice) {
        return productService.getAllProductsByPriceGreaterThan(minPrice);
    }
   

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> putProduct(@PathVariable Long id, @RequestBody Product product){
        product.setId(id);
        Pair<Boolean, Product> result = productService.EditProduct(product);
        return (!result.getFirst())
        ? new ResponseEntity<>(result.getSecond(), HttpStatus.CREATED)
        : new ResponseEntity<Product>(result.getSecond(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
