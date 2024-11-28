package com.myspring.bootstrap.auth.service;

import com.myspring.bootstrap.auth.dto.SignUpDto;
import com.myspring.bootstrap.entity.User;
import com.myspring.bootstrap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;

    public void signUp(SignUpDto signUpDto) {

        Optional<User> optUser = userRepository.findByEmail(signUpDto.getEmail());
        if (optUser.isPresent()) {
            User userr = optUser.get();
            System.out.println(userr.getEmail());
        }

        BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();

        User user = new User();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(pwdEncoder.encode(signUpDto.getPassword()));
        user.setCreated_at(new Date());
        user.setUpdated_at(new Date());

        userRepository.save(user);
    }
}
