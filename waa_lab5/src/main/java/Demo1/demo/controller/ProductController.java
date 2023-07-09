package Demo1.demo.controller;

import Demo1.demo.entity.Category;
import Demo1.demo.entity.Product;
import Demo1.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = {"/add"})
    public void createProduct(Product product){
        productService.createProduct(product);
    }

    @PostMapping(value = {"/update"})
    public void updateProduct(@RequestBody Product product, Long productId){
        productService.updateProduct(product, productId);
    }

    @DeleteMapping(value = {"/delete"})
    public void deleteProduct(Long productId){
        productService.deleteProduct(productId);
    }
    @GetMapping(value = {"/get"})
    public void getProductById( Long productId){
        productService.getProductById(productId);
    }

    @GetMapping(value = {"/","/getAll"})
    public ResponseEntity<?> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = {"/byPrice"})
    public void getAllByPrice(Double price){
        productService.findAllByPriceGreaterThan(price);
    }


    @GetMapping(value = { "/byCategory"})
    public void getAllProductsByMaxPrice(Category category, double maxPrice){
        productService.findAllByCategoryAndPriceLessThan(category, maxPrice);
    }
@GetMapping(value = { "/byKeyword"})
    public void getAllProductsByName(String keyword){
        productService.findAllByNameContainingIgnoreCase(keyword);
    }
}
