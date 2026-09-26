package com.hw.todo.service;


import com.hw.todo.exception.InformationNotFoundException;
import com.hw.todo.model.Category;
import com.hw.todo.model.Item;
import com.hw.todo.repository.CategoryRepository;
import com.hw.todo.repository.ItemRepository;
import lombok.AllArgsConstructor;
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
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new InformationNotFoundException("Category with id: "+ categoryId +" does not exist..."));
        newItem.setCategory(category);
        return itemRepository.save(newItem);
    }

    //Get category items
    public List<Item> itemList(Long categoryId){
        System.out.println("SERVICE Calling itemList()==>");
        return itemRepository.findByCategoryId(categoryId);
    }

    // Get a specific item
    public Item retrieveItem(Long categoryId, Long itemId){
        System.out.println("SERVICE Calling retrieveItem()==>");
        Category category= categoryRepository.findById(categoryId)
                .orElseThrow(()-> new InformationNotFoundException("Category with id: "+ categoryId +" does not exist..."));
        return itemRepository.findById(itemId).filter(item1 -> item1.getCategory().getId().equals(categoryId)).orElseThrow(()-> new InformationNotFoundException("Category with id: "+ categoryId +" does not exist..."));
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
