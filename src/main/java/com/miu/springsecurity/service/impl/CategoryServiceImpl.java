package com.miu.springsecurity.service.impl;

import com.miu.springsecurity.aspect.annotation.ExecutionTime;
import com.miu.springsecurity.entity.Category;
import com.miu.springsecurity.repository.CategoryRepo;
import com.miu.springsecurity.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;


    @Override
    @ExecutionTime
    public List<Category> findAll() {
        return (List<Category>) categoryRepo.findAll();
    }

    @Override
    @ExecutionTime
    public void save(Category category) {
        categoryRepo.save(category);
    }

    @Override
    @ExecutionTime
    public Category findById(int id) {
        return categoryRepo.findById(id).get();
    }

    @Override
    @ExecutionTime
    public void deleteById(int id) {
        categoryRepo.deleteById(id);
    }
}
