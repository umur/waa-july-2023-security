package com.waa.lab3.controller;

import com.waa.lab3.entity.Category;
import com.waa.lab3.entity.Product;
import com.waa.lab3.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping("categories")
    public String addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }
    @GetMapping("categories/{id}")
    public Category getById(@PathVariable Long id){
        return categoryService.getById(id);
    }
    @GetMapping("categories")
    public List<Category> getAllBy(){
        return categoryService.getAllBy();
    }
    @PutMapping("categories/{id}")
    public String updateAddress(@PathVariable Long id, @RequestBody Category category){
        return categoryService.updateCategory(id, category);
    }
    @DeleteMapping("categories/{id}")
    public String deleteAddress(@PathVariable Long id){
        return categoryService.deleteCategory(id);
    }

}
