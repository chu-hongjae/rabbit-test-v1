package com.example.securityv1.service;

import com.example.securityv1.dao.UserRepo;
import com.example.securityv1.model.PrincipalDetails;
import com.example.securityv1.model.entity.User;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    @PostConstruct
    public void initUser(){

        repo.deleteAll();

        User user = new User();
        user.setUsername("chu");
        user.setPassword("1234");
        user.setRole("ADMIN");
        repo.save(user);


    }

    private final UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User entity =repo.findByUsername(username);

        if(entity != null){
            return new PrincipalDetails(entity);
        }
        return null;
    }
}
