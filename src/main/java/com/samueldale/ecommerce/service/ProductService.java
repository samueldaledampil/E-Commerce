package com.samueldale.ecommerce.service;

import com.samueldale.ecommerce.model.Product;
import com.samueldale.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    List<Product> productList = null;

    public List<Product> getAllProducts(){
        return repo.findAll();
    }


//    public Product getProductById(long id){
//        return repo.findById(id)
//                .orElseThrow(() -> new ProductNotFoundException(id));
//    }

    public Product getProductById(long id){
        return productList.stream()
                .filter(product -> product.getId()==id)
                .findAny()
                .orElseThrow(()-> new RuntimeException("Product not found."));
    }

    public Product addProduct(Product product) {
        return repo.save(product);
    }
}
