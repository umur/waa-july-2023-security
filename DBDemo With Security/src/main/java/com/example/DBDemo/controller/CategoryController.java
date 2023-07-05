package com.example.DBDemo.controller;

import com.example.DBDemo.entity.Category;
import com.example.DBDemo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    final private CategoryService categoryService;

    @PostMapping
    public void saveCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
    }
}
