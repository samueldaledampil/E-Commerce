package com.samueldale.ecommerce.service;

import com.samueldale.ecommerce.config.UserEntityUserDetailConfig;
import com.samueldale.ecommerce.model.UserEntity;
import com.samueldale.ecommerce.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserEntityUserDetailService implements UserDetailsService {

    @Autowired
    private UserEntityRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userEntityOptional = repo.findByUsername(username);

        return userEntityOptional.map(UserEntityUserDetailConfig::new)
                .orElseThrow(() ->  new UsernameNotFoundException("Username not found."));

    }
}
