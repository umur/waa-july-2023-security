package com.miu.waa.lab3.service;

import java.util.List;

import com.miu.waa.lab3.entity.Category;

public interface CategoryService {
    Category findById(Integer id);
    List<Category> findAll();
    Category create(Category category);
    Category update(Category category);
    Category delete(Integer id);
}
