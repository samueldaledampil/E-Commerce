package com.samueldale.ecommerce.controller;

import com.samueldale.ecommerce.model.Category;
import com.samueldale.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/categories")
    public List<Category> getAllCategories(){
        return service.getAllCategories();
    }

    @PostMapping("/category/add")
    public Category addCategory(@RequestBody Category category){
        return service.addCategory(category);
    }

}
