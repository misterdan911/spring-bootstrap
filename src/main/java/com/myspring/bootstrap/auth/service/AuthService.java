package com.myspring.bootstrap.auth.service;

import com.myspring.bootstrap.auth.dto.LoginUpDto;
import com.myspring.bootstrap.auth.dto.SignUpDto;
import com.myspring.bootstrap.auth.exception.InvalidLoginException;
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

    public User signUp(SignUpDto signUpDto) {

        BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();

        User user = new User();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(pwdEncoder.encode(signUpDto.getPassword()));
        user.setCreated_at(new Date());
        user.setUpdated_at(new Date());

        return userRepository.save(user);
    }

    public User authenticateUser(LoginUpDto loginDto) {
        Optional<User> rsUser = userRepository.findByUsername(loginDto.getUsername());

        // Check by username or email
        if (rsUser.isEmpty()) {
            rsUser = userRepository.findByEmail(loginDto.getUsername());
            if (rsUser.isEmpty()) {
                throw new InvalidLoginException();
            }
        }

        User user = rsUser.get();
        BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
        boolean pwdMatched = pwdEncoder.matches(loginDto.getPassword(), user.getPassword());

        if (!pwdMatched) {
            throw new InvalidLoginException();
        }

        return user;
    }
}
