package com.hw.todo.repository;

import com.hw.todo.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findByName(String itemName);
    List<Item> findByCategoryId(Long categoryId);

    Optional<Item> findByIdAndUserId(Long itemId, Long id);
}
