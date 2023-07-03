package com.example.demo.service.impl;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepo;
import com.example.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepo categoryRepo;

    public void create(Category category) {
        categoryRepo.save(category);
    }

    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public void update(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepo.findById(id).orElseGet(null);
    }

    @Override
    public void delete(Category category) {
        categoryRepo.delete(category);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepo.findByName(name);
    }
}
