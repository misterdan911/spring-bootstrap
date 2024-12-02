package com.myspring.bootstrap.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping(value = "/api/user")
    public ResponseEntity<?> getUser()
    {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }


}
