package com.myspring.bootstrap.auth.service;

import com.myspring.bootstrap.auth.dto.SignUpDto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public void signUp(SignUpDto signUpDto) {
        BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
        String pass = pwdEncoder.encode(signUpDto.getPassword());
        System.out.println(pass);
    }
}
