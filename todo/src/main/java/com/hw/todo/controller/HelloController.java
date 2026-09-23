package com.hw.todo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(){
        System.out.println("Calling sayHello==>");
        return "Hello, World!";
    }
}
