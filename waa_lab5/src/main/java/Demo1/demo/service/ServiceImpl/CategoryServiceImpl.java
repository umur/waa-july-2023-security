package Demo1.demo.service.ServiceImpl;

import Demo1.demo.entity.Category;
import Demo1.demo.repository.CategoryRepository;
import Demo1.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryServiceImpl implements CategoryService {

 @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void updateCategoryById(Category category, Long categoryId) {

        categoryRepository.findById(categoryId).map(category1 -> {
            category1.setName(category.getName());
            return categoryRepository.save(category1);
        });
    }
    @Override
    public void deleteCategory(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public void findAllCategory() {
        categoryRepository.findAll();
    }


}

