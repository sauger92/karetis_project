package com.auger.karetisproject.service;

import com.auger.karetisproject.entity.User;
import com.auger.karetisproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class InitUser {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init(){
        User user = new User(
                "Simon",
                passwordEncoder.encode("password"));

        if (!userRepository.findByUsername(user.getUsername()).isPresent()){
            userRepository.save(user);
        }
    }
}
