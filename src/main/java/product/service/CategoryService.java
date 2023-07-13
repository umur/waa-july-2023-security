package product.service;

import product.dto.category.CreateCategoryDto;
import product.dto.category.UpdateCategoryDto;
import product.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(Long id);

    Category create(CreateCategoryDto categoryDto);

    Category update(UpdateCategoryDto updateCategoryDto);

    Category delete(Long id);
}
