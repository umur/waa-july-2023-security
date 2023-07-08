package lab4.security.controller;

import lab4.security.entity.Category;
import lab4.security.exceptions.CustomError;
import lab4.security.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getall() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(Long id) {
        Optional<Category> category = categoryService.findById(id);

        if (category.isEmpty()) {
            return new ResponseEntity<>(new CustomError("Category " + id + " not found"), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(category.get());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.create(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody Category category) {
        Optional<Category> updatedCategory = categoryService.update(id, category);
        if (updatedCategory.isEmpty()) {
            return new ResponseEntity<>(new CustomError("Category " + id + " not found"), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(updatedCategory.get());
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
    }


}
