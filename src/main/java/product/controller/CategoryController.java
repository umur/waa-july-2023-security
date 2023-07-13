package product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import product.dto.category.CreateCategoryDto;
import product.dto.category.UpdateCategoryDto;
import product.entity.Category;
import product.entity.Product;
import product.service.CategoryService;
import product.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
public class CategoryController {

    private final CategoryService categoryService;

    private final ProductService productService;

    @GetMapping
    public List<Category> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("{id}")
    public Category findById(@PathVariable Long id){
        return categoryService.findById(id);
    }

    @GetMapping("{id}/products")
    public List<Product> findProductsByCategoryId(@PathVariable Long id){
        return productService.findAllByCategoryId(id);
    }

    @PostMapping
    public Category create(@RequestBody  CreateCategoryDto categoryDto){
        return categoryService.create(categoryDto);
    }

    @PutMapping("{id}")
    public Category update(@PathVariable Long id, @RequestBody UpdateCategoryDto categoryDto){
        categoryDto.setId(id);
        return categoryService.update(categoryDto);
    }

    @DeleteMapping("{id}")
    public Category delete(@PathVariable Long id){
        return categoryService.delete(id);
    }

}
