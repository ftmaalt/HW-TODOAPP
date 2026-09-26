package com.hw.todo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
@Entity
@Table(name="categories")
public class Category {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(fetch=FetchType.EAGER, mappedBy = "category", orphanRemoval = true)

    private List<Item> itemList;


}
