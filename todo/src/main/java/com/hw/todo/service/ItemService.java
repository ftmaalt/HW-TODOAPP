package com.hw.todo.service;


import com.hw.todo.exception.InformationNotFoundException;
import com.hw.todo.model.Category;
import com.hw.todo.model.Item;
import com.hw.todo.repository.CategoryRepository;
import com.hw.todo.repository.ItemRepository;
import com.hw.todo.security.MyUserDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemService {
    private ItemRepository itemRepository;
    private CategoryRepository categoryRepository;


    //Create new category item
    public Item createItem(Long categoryId, Item newItem){
        System.out.println("SERVICE Calling creatItem()==>");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        Optional<Category> category = categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
        if (category.isPresent()) {
            newItem.setCategory(category.get());
            newItem.setUser(userDetails.getUser());
            return itemRepository.save(newItem);
        } else {
            throw new InformationNotFoundException("Category with id " + categoryId + " not found");
        }
    }

    //Get category items
    public List<Item> itemList(Long categoryId){
        System.out.println("SERVICE Calling itemList()==>");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        Optional<Category> category = categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
        if (category.isPresent()) {
            return itemRepository.findByCategoryId(categoryId);
        } else {
            throw new InformationNotFoundException("Category with id " + categoryId + " not found");
        }
    }

    // Get a specific item
    public Item retrieveItem(Long categoryId, Long itemId){
        System.out.println("SERVICE Calling retrieveItem()==>");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        Optional<Category> category = categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
        if (category.isPresent()) {
            Optional<Item> item = itemRepository.findByIdAndUserId(itemId, userDetails.getUser().getId());
            if (item.isPresent() && item.get().getCategory().getId().equals(categoryId)) {
                return item.get();
            } else {
                throw new InformationNotFoundException("Item with id " + itemId + " not found");
            }
        } else {
            throw new InformationNotFoundException("Category with id " + categoryId + " not found");
        }
    }

    //update an item
    public Item updateItem(Long categoryId, Long itemId, Item newItem){
        System.out.println("SERVICE Calling updateItem()==>");
        Category category= categoryRepository.findById(categoryId).orElseThrow(()-> new InformationNotFoundException("No category with id "+ categoryId+" exists"));
        Item item= itemRepository.findById(itemId).orElseThrow(()-> new InformationNotFoundException("No item with id "+ itemId+" exists"));
        item.setName(newItem.getName());
        item.setCategory(category);
        item.setDescription(newItem.getDescription());
        item.setDueDate(newItem.getDueDate());
        return itemRepository.save(item);
    }

    //delete an item
    public String deleteItem(Long itemId){
        System.out.println("SERVICE Calling deleteItem()");
        Item item= itemRepository.findById(itemId)
                .orElseThrow(()-> new InformationNotFoundException("Item with id: "+ itemId+" not found."));
        itemRepository.delete(item);
        return "Item with id: "+itemId+" has been successfully deleted.";
    }
}
