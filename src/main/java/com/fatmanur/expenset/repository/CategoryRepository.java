package com.fatmanur.expenset.repository;


import com.fatmanur.expenset.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long> {
    Category findCategoryByCategoryName(String categoryName);

}