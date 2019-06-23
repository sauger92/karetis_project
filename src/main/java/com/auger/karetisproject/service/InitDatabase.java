package com.auger.karetisproject.service;

import com.auger.karetisproject.entity.User;
import com.auger.karetisproject.repository.RandomDataRepository;
import com.auger.karetisproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class InitDatabase {


    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RandomDataRepository randomDataRepository;

    @PostConstruct
    public void init() {
        initUser();
        cleanDatabase();
    }

    private void cleanDatabase() {
        randomDataRepository.deleteAll();
    }

    private void initUser() {
        User user = new User(
                "Simon",
                passwordEncoder.encode("password"));

        if (!userRepository.findByUsername(user.getUsername()).isPresent()) {
            userRepository.save(user);
        }
    }
}
