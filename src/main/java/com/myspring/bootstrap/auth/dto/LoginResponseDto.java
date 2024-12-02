package com.myspring.bootstrap.auth.dto;

import lombok.Data;

@Data
public class LoginResponseDto {

    private Long Id;
    private String name;
    private String username;
    private String email;
    private String jwtToken;
}
