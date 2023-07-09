package online.moumini.spring.data.one.service;

import online.moumini.spring.data.one.model.Category;
import online.moumini.spring.data.one.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Pair<Boolean, Category> EditCategory(Category category) {
        boolean exists = categoryRepository.existsById(category.getId());
        categoryRepository.save(category);
        return Pair.of(exists, category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
