package com.samueldale.ecommerce.service;

import com.samueldale.ecommerce.exception.UserNotFoundException;
import com.samueldale.ecommerce.model.UserEntity;
import com.samueldale.ecommerce.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserEntityService {

    @Autowired
    private UserEntityRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UserEntity> getAllUsers(){
        return repo.findAll();
    }

    public UserEntity getUserById(long id){

        return repo.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }

    public UserDetails getUserByUsername(String username) throws UserNotFoundException{
        Optional<UserEntity> userEntity = repo.findByUsername(username);

        return null;
    }

    public String addUser(UserEntity userEntity) {

        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        repo.save(userEntity);
        return ("User has been added successfully.");
    }

}
