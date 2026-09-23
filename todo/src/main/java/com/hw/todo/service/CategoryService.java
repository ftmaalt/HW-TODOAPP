package com.hw.todo.service;

import com.hw.todo.exception.InformationExistsException;
import com.hw.todo.model.Category;
import com.hw.todo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category categoryObject) {
        System.out.println("Service Calling createCategory ===>");

        Category category = categoryRepository.findByName(categoryObject.getName());
        return categoryRepository.save(categoryObject);
    }


    public List<Category> getCategories() {
        System.out.println("Service Calling getCategories() ==>");
        return categoryRepository.findAll();
    }

    public Optional<Category> findCategoryById(Long id){
        System.out.println("Service Calling findCategoryById(Long id)==>");
        return categoryRepository.findById(id);
    }





}
