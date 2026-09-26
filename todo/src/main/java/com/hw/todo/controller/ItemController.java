package com.hw.todo.controller;


import com.hw.todo.model.Item;
import com.hw.todo.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ItemController {

    private ItemService itemService;

    @PostMapping("/categories/{categoryId}/items")
    public Item createItem(@PathVariable(value = "categoryId") Long categoryId, @RequestBody Item newItem){
        System.out.println("Calling createItem()==>");
        return itemService.createItem(categoryId, newItem);
    }


    @GetMapping("/categories/{categoryId}/items")
    public List<Item> itemList(@PathVariable(value = "categoryId")Long categoryId){
        System.out.println("Calling itemList()==>");
        return itemService.itemList(categoryId);
    }
    @GetMapping("/categories/{categoryId}/items/{itemId}")
    public Item getCategoryItem(@PathVariable Long categoryId, @PathVariable Long itemId) {
        return itemService.retrieveItem(categoryId, itemId);
    }


    @PutMapping("/categories/{categoryId}/items/{itemId}")
    public Item updateRecipe(@PathVariable(value = "categoryId")Long categoryId, @PathVariable(value = "itemId")Long itemId, @RequestBody Item itemObject){
        System.out.println("Calling updateItem()==>");
        return itemService.updateItem(categoryId, itemId, itemObject);
    }



    @DeleteMapping("/categories/{categoryId}/items/{itemId}")
    public String deleteRecipe(@PathVariable(value = "itemId") Long itemId){
        System.out.println("Calling deleteItem()==>");
        return itemService.deleteItem(itemId);
    }


    }
