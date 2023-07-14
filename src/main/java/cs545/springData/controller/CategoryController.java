package cs545.springData.controller;

import cs545.springData.entity.Category;
import cs545.springData.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping
public class CategoryController {


        private final CategoryService categoryService;

        @GetMapping("/categories")
        public List<Category> getCategory(){
            return categoryService.getCategory();
        }
        @PostMapping("/categories")
        public Category addCategory(@RequestBody Category category){
            categoryService.addCategory(category);
            return category;
        }
        @GetMapping("/categories/{id}")
        public Category getCategoryById(@PathVariable Long id){
            return categoryService.getById(id);
        }

        @PutMapping("/categories/{id}")
        public Category updateCategory(@PathVariable Long id,@RequestBody Category category){
            return categoryService.updateCategory(id,category);

        }
        @DeleteMapping("/categories/{id}")
        public String deleteById(@PathVariable Long id){
            return categoryService.DeleteById(id);
        }
}
