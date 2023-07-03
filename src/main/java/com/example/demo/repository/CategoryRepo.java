package com.example.demo.repository;

import com.example.demo.entity.Category;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends ListCrudRepository<Category, Long> {
    Category findByName(String name);
}
