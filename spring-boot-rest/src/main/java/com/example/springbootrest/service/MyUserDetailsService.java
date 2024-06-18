package com.example.springbootrest.service;

import com.example.springbootrest.model.User;
import com.example.springbootrest.model.UserPrinciple;
import com.example.springbootrest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repo.findByUsername(username);

        if (user == null){
            System.out.println("User 404");
            throw new UsernameNotFoundException("User not found");
        }

        return new UserPrinciple(user);
    }
}
