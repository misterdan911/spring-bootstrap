package com.myspring.bootstrap.auth.dto;

import lombok.Data;

@Data
public class LoginUpDto {

    private String username;
    private String email;
    private String password;
}
