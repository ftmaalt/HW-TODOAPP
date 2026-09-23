package com.hw.todo.service;

import com.hw.todo.exception.InformationExistsException;
import com.hw.todo.exception.InformationNotFoundException;
import com.hw.todo.model.Category;
import com.hw.todo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PutMapping("/categories/updatedAt")
    public Optional<Category> updateCategory(String oldname,String name, String description) {
        System.out.println("Services Calling updatedAt(Long id)==>");
        Optional<Category> category= Optional.ofNullable(categoryRepository.findByName(oldname));
        if (category.isPresent()){
            if (oldname.equalsIgnoreCase(name)){
                throw new InformationExistsException("Error updating, both new category name and old category name are the same");
            }else{
                Category updatedcategory= categoryRepository.findByName(oldname);
                updatedcategory.setName(name);
                updatedcategory.setDescription(description);
                return Optional.of(categoryRepository.save(updatedcategory));
            }

        } else{
            throw new InformationNotFoundException("Category with name "+ oldname+" not found..");
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
