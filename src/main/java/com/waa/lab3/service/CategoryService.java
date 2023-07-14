package com.waa.lab3.service;

import com.waa.lab3.entity.Category;

import java.util.List;

public interface CategoryService {
    public String addCategory(Category category);
    public Category getById(Long id);
    List<Category> getAllBy();
    String updateCategory(Long id, Category category);
    String deleteCategory(Long id);

}
