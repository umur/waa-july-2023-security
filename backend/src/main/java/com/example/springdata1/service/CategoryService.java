package com.example.springdata1.service;

import com.example.springdata1.entity.Category;

import java.util.List;


public interface CategoryService {
    List<Category> findAll();

    Category findById(Long id);

    Category add(Category category);

    Category update(Category category);

    void delete(Long id);

}
