package com.waa.lab3.service;
import com.waa.lab3.entity.Category;
import com.waa.lab3.entity.Product;
import com.waa.lab3.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public String addCategory(Category category){
       categoryRepo.save(category);
       return "category added";
    }
    @Override
    public Category getById(Long id){
        Optional<Category> cat= categoryRepo.findById(id);
        if(cat.isPresent())return cat.get();
        else return null;
    }
    @Override
    public List<Category> getAllBy(){
        return categoryRepo.findAll();
    }
    @Override
    public String updateCategory(Long id, Category category){
        Optional<Category>cat=categoryRepo.findById(id);
        if(cat.isPresent()){
            Category c=cat.get();
            c.setName(category.getName());
            c.setProductList(category.getProductList());
        }
        return "category updated";
    }
    @Override
    public String deleteCategory(Long id){
        categoryRepo.deleteById(id);
        return "category deleted";
    }

}
