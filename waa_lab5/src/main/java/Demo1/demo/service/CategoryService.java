package Demo1.demo.service;

import Demo1.demo.entity.Category;
import Demo1.demo.entity.Product;

import java.util.List;

public interface CategoryService {

    void addCategory(Category category);


    void updateCategoryById(Category category, Long categoryId);

    void deleteCategory(Category category);


    void findAllCategory();
}
