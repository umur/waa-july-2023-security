package cs545.Controller;

import cs545.Domain.Product;
import cs545.Domain.Review;
import cs545.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // GET /products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // GET /products/{id}
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    // POST /products
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    // PUT /products/{id}
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    // DELETE /products/{id}
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }

    // GET /products?minPrice={minPrice}
    @GetMapping("/price")
    public List<Product> getProductsByMinPrice(@RequestParam Double minPrice) {
        return productService.getProductsGreaterThanMinPrice(minPrice);
    }

    // GET /products?category={categoryId}&maxPrice={maxPrice}
    @GetMapping("/cateAndPrice")
    public List<Product> getProductsByCategoryAndMaxPrice(@RequestParam String categoryName, @RequestParam Double maxPrice) {
        return productService.getProductsByCategoryAndMaxPrice(categoryName, maxPrice);
    }

    // GET /products?keyword={keyword}
    @GetMapping("/keyword")
    public List<Product> getProductsByKeyword(@RequestParam String keyword) {
        return productService.getProductsByKeyword(keyword);
    }

    // GET /products/{id}/reviews
    @GetMapping("/{id}/reviews")
    public List<Review> getProductReviews(@PathVariable Integer id) {
        return productService.getProductReviews(id);
    }
}
