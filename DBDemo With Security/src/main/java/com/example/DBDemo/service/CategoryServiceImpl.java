package com.example.DBDemo.service;

import com.example.DBDemo.entity.Category;
import com.example.DBDemo.reposiroty.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{

    final private CategoryRepository categoryRepository;

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }
}
