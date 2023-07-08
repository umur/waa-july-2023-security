package lab4.security.service.impl;

import lab4.security.entity.Category;
import lab4.security.repository.CategoryRepo;
import lab4.security.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public List<Category> getAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepo.findById(id);
    }

    @Override
    public Category create(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Optional<Category>  update(Long id,Category updatedCategory) {
        Optional<Category>  existingCategory = findById(id);
        if(existingCategory.isEmpty()){
            return existingCategory;
        }
        existingCategory.get().setName(updatedCategory.getName());
        return Optional.of(categoryRepo.save(existingCategory.get()));
    }

    @Override
    public void deleteById(Long id) {
        categoryRepo.deleteById(id);
    }

}
