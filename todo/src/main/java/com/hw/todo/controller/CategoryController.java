package com.hw.todo.controller;

import com.hw.todo.exception.InformationExistsException;
import com.hw.todo.model.Category;
import com.hw.todo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    //CRUD
    //C-- Create
    @PostMapping("/categories")
    public Category createCategory(@RequestBody Category categoryObject) {
        System.out.println("Calling createCategory ===>");
        return categoryService.createCategory(categoryObject);
    }



    //R-- Read
    @GetMapping("/categories")
    public List<Category> getCategories(){
        System.out.println("Calling getCategories() ==>");
        return categoryService.getCategories();

    }
    @GetMapping("/categories/{categoryId}")
    public Optional<Category> findCategoryById(@PathVariable(value = "categoryId") Long id){
        System.out.println("Calling findCategoryById(Long id)==>");
        return categoryService.findCategoryById(id);
    }
    //U -- Update
    @PutMapping("/categories/{categoryId}")
    public Category updateCategory(@PathVariable(value = "categoryId") Long categoryId, @RequestBody Category categoryObject){
        System.out.println("Calling updateCategory()==>");
        return categoryService.updateCategory(categoryId, categoryObject);
    }
    //D -- Delete


    @DeleteMapping("/categories/{categoryId}")
    public String deleteCategory(@PathVariable(value = "categoryId") Long categoryId){
        System.out.println("Calling deleteCategory(Long id)==>");
        return categoryService.deleteCategory(categoryId);

    }
}
