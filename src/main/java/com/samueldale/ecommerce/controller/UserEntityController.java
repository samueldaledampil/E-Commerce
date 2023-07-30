package com.samueldale.ecommerce.controller;

import com.samueldale.ecommerce.model.UserEntity;
import com.samueldale.ecommerce.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserEntityController {

    @Autowired
    private UserEntityService service;

    @GetMapping(value = "/all")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public List<UserEntity> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public UserEntity getUserById(@PathVariable Long id){
        return service.getUserById(id);
    }

    @PostMapping("/add")
//    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public String addUser(@RequestBody UserEntity newUser){
        return service.addUser(newUser);
    }

}
