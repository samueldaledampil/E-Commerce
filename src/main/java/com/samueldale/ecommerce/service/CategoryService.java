package com.samueldale.ecommerce.service;

import com.samueldale.ecommerce.model.Category;
import com.samueldale.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

    public List<Category> getAllCategories(){
        return repo.findAll();
    }

    public Category addCategory(Category category){
        return repo.save(category);
    }

}
