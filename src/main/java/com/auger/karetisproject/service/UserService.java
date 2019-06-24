package com.auger.karetisproject.service;

import com.auger.karetisproject.entity.User;
import com.auger.karetisproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (!userOptional.isPresent()){
            throw new UsernameNotFoundException("Invalid username or password.");
        }else {
            User user = userOptional.get();
            return new org.springframework.security.core.userdetails.User(user.getUsername(),
                    user.getPassword(), getAuthorities());
        }


    }


    private Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<>();
    }

}
