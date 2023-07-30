package com.samueldale.ecommerce.controller;

import com.samueldale.ecommerce.dto.AuthRequest;
import com.samueldale.ecommerce.model.UserEntity;
import com.samueldale.ecommerce.service.JwtService;
import com.samueldale.ecommerce.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserEntityController {

    @Autowired
    private UserEntityService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

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
    public String addUser(@RequestBody UserEntity newUser){
        return service.addUser(newUser);
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest){
         Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest
                 .getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUsername());
        }else{
            throw new UsernameNotFoundException("Invalid login credentials");
        }
    }

}
