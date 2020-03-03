package com.fatmanur.expenset.controller;

import com.fatmanur.expenset.model.Category;
import com.fatmanur.expenset.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping("/api-category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping(value = "/categories")
    Collection<Category> categories() {
        return categoryService.findAllCategories();
    }

    @GetMapping("/getcategory/{id}")
    ResponseEntity<?> getCategory(@PathVariable Long id){
        return categoryService.findCategoryById(id);
    }

    @PostMapping("/savecategory")
    ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) throws URISyntaxException {
        Category result= categoryService.createCategory(category);
        return ResponseEntity.created(new URI("/api/category" + result.getId())).body(result);
    }

    @PutMapping("/updatecategory/{id}")
    ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category){
        Category result= categoryService.createCategory(category);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/deletecategory/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable Long id){
        categoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}