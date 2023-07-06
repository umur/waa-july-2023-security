package com.miu.waa.lab3.repo;

import org.springframework.data.repository.ListCrudRepository;

import com.miu.waa.lab3.entity.Category;

public interface CategoryRepo extends ListCrudRepository<Category, Integer> {

}
