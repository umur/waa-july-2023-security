package product.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import product.annotation.ProfanityFilter;
import product.dto.category.CreateCategoryDto;
import product.dto.category.UpdateCategoryDto;
import product.entity.Category;
import product.repository.CategoryRepo;
import product.service.CategoryService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<Category> findAll(){
        return categoryRepo.findAll();
    }

    @Override
    public Category findById(Long id){
        return categoryRepo.findById(id).get();
    }

    @Override
    @ProfanityFilter
    public Category create(CreateCategoryDto categoryDto){
        Category category = modelMapper.map(categoryDto, Category.class);
        return categoryRepo.save(category);
    }

    @Override
    public Category update(UpdateCategoryDto updateCategoryDto){
        Category category = findById(updateCategoryDto.getId());
        modelMapper.map(updateCategoryDto, category);
        return categoryRepo.save(category);
    }

    @Override
    public Category delete(Long id){
        Category category = findById(id);
        categoryRepo.delete(category);
        return category;
    }
}
