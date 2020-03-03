package com.fatmanur.expenset.service;


import com.fatmanur.expenset.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface  CategoryService {
    public Collection<Category> findAllCategories();
    public ResponseEntity<?> findCategoryById(Long id);

    Category createCategory(Category category);

    void deleteById(Long id);


}