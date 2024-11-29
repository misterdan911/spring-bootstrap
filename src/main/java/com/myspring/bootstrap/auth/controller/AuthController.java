package com.myspring.bootstrap.auth.controller;

import com.myspring.bootstrap.auth.dto.SignUpDto;
import com.myspring.bootstrap.auth.service.AuthService;
import com.myspring.bootstrap.entity.User;
import com.myspring.bootstrap.shared.response.ResponseSuccess;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    public AuthService authService;

    // @ModelAttribute
    @PostMapping(value = "/api/auth/signup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpDto signUpDto)
    {
        User newUser = authService.signUp(signUpDto);
        signUpDto.setId(newUser.getId());
        ResponseSuccess<SignUpDto> response = new ResponseSuccess<>(signUpDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
