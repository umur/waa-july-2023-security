package cs545.springData.controller;

import cs545.springData.entity.Category;
import cs545.springData.entity.Product;
import cs545.springData.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getCategory(){
        return productService.getProduct();
    }
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return product;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/productess/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getById(id);
    }

    @GetMapping("/productes/{minPrice}")
    public  List<Product>  findByPriceGreaterThan(@PathVariable Double minPrice){
        return productService.findByPriceGreaterThan(minPrice);
    }
    @GetMapping("/products/{maxPrice}")
    public List<Product> findByCategoryAndPriceLessThan(@RequestBody Category category, @PathVariable Double maxPrice){
        return productService.findByCategoryAndPriceLessThan(category,maxPrice);
    }
    @GetMapping("/productss/{keyword}")
    public List<Product> findByNameContaining(@PathVariable String keyword){
        return productService.findByNameContaining(keyword);
    }
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable Long id,@RequestBody Product product){
        return productService.updateProduct(id,product);

    }
    @DeleteMapping("/products/{id}")
    public String deleteById(@PathVariable Long id){
        return productService.DeleteById(id);
    }
}
