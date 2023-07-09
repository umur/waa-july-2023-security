package Demo1.demo.controller;

import Demo1.demo.entity.Category;
import Demo1.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public String addCategory(Category category){
        categoryService.addCategory(category);
        return "Category added";
    }

    @PutMapping("/update")
    public String updateCategory(Long Id, Category category){
        categoryService.updateCategoryById(category, Id);
        return "Category updated";
    }

    @DeleteMapping("/delete")
    public String deleteCategory(Category category){
        categoryService.deleteCategory(category);
        return "Category deleted";
    }

    @GetMapping("/all")
    public String findAllCategory(){
        categoryService.findAllCategory();
        return "All categories";
    }


}
