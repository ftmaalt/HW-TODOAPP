package com.hw.todo.service;

import com.hw.todo.exception.InformationExistsException;
import com.hw.todo.exception.InformationNotFoundException;
import com.hw.todo.model.Category;
import com.hw.todo.repository.CategoryRepository;
import com.hw.todo.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;



    public Category createCategory(Category categoryObject) {
        System.out.println("Service Calling createCategory ===>");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        Category category = categoryRepository.findByUserIdAndName(
                userDetails.getUser().getId(), categoryObject.getName());
        if (category != null) {
            throw new InformationExistsException("Category with name " + categoryObject.getName() + " already exists.");
        } else {
            categoryObject.setUser(userDetails.getUser());
            return categoryRepository.save(categoryObject);
        }
    }


    public List<Category> getCategories() {
        System.out.println("Service Calling getCategories ===>");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return categoryRepository.findByUserId(userDetails.getUser().getId());
    }

    public Optional<Category> findCategoryById(Long categoryId) {
        System.out.println("Service Calling findCategoryById ===>");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        Optional<Category> category = categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
        if (category.isPresent()) {
            return category;
        } else {
            throw new InformationNotFoundException("Category with id " + categoryId + " not found");
        }
    }


        public Category updateCategory(Long categoryId, Category categoryObject) {
            System.out.println("Service Calling updateCategory ==>");
            Optional<Category> category = categoryRepository.findById(categoryId);
            if (category.isPresent()) {
                Category existingCategory = category.get();
                Category categoryWithName = categoryRepository.findByName(categoryObject.getName());
                if (categoryWithName != null && !categoryWithName.getId().equals(categoryId)) {
                    throw new InformationExistsException("Category with name " + categoryObject.getName() + " already exists.");
                }

                existingCategory.setName(categoryObject.getName());
                existingCategory.setDescription(categoryObject.getDescription());
                return categoryRepository.save(existingCategory);
            } else {
                throw new InformationNotFoundException("Category with id " + categoryId + " not found.");
            }
    }


    public String deleteCategory(Long id) {
        System.out.println("Service Calling deleteCategory ===>");
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            categoryRepository.deleteById(id);
            return "Category with id"+ id +"has been deleted successfully";
        } else {
            throw new InformationNotFoundException("Category with id "+ id +"not found.");
        }
    }



}
