package com.miu.springsecurity.service;

import com.miu.springsecurity.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    void save(Category category);
    Category findById(int id);
    void deleteById(int id);

}
