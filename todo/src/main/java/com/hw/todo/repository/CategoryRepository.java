package com.hw.todo.repository;

import com.hw.todo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String categoryName);
    Category findByNameAndDescription(String categoryName, String descriptionName);
    Category findByUserIdAndName(Long userId, String categoryName);
    Category findByUserIdAndCategoryId(Long userId, Long id);
    List<Category> findByUserId(Long userId);    Optional<Category> findByIdAndUserId(Long categoryId, Long id);
}