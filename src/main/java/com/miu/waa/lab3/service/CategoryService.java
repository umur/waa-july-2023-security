package com.miu.waa.lab3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.miu.waa.lab3.entity.Category;
import com.miu.waa.lab3.repo.CategoryRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public Category findById(Integer id) {
        Optional<Category> optionalCategory = categoryRepo.findById(id);

        if (!optionalCategory.isPresent()) {
            throw new RuntimeException("Category is not found.");
        }

        return optionalCategory.get();
    }

    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    public Category create(Category category) {
        return categoryRepo.save(category);
    }

    public Category update(Category category) {
        Category tempCategory = findById(category.getId());

        tempCategory.setName(category.getName());

        return categoryRepo.save(tempCategory);
    }

    public Category delete(Integer id) {
        Category tempCategory = findById(id);
        categoryRepo.delete(tempCategory);

        return tempCategory;
    }

}
