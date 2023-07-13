package product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import product.dto.product.CreateProductDto;
import product.dto.product.UpdateProductDto;
import product.entity.Product;
import product.entity.Review;
import product.service.ProductService;
import product.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN') and hasAuthority('USER')")
public class ProductController {

    private final ProductService productService;
    private final ReviewService reviewService;

    @GetMapping
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("{id}")
    public Product findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @PostMapping
    public Product create(@RequestBody CreateProductDto productDto){
        return productService.create(productDto);
    }

    @PutMapping("{id}")
    public Product update(@PathVariable Long id, @RequestBody UpdateProductDto productDto){
        productDto.setId(id);
        return productService.update(productDto);
    }

    @DeleteMapping("{id}")
    public Product delete(@PathVariable Long id){
        return productService.delete(id);
    }


    @GetMapping("{id}/reviews")
    public List<Review> findReviewsByProduct(@PathVariable Long id){
        return reviewService.findAllByProductId(id);
    }

    @GetMapping("filter/name")
    public List<Product> findAllByNameContaining(@RequestParam String keyword){
        return productService.findAllByNameContaining(keyword);
    }

    @GetMapping("filter/min-price")
    public List<Product> findAllByPriceGreaterThan(@RequestParam double minPrice){
        return productService.findAllByPriceGreaterThan(minPrice);
    }
}
