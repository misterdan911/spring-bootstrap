package com.myspring.bootstrap.auth.dto;

import com.myspring.bootstrap.auth.validation.EmailNotDuplicate;
import com.myspring.bootstrap.auth.validation.StrongPassword;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignUpDto {

    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Username is mandatory")
    private String username;

    @NotBlank(message = "Email is mandatory")
    @EmailNotDuplicate
    private String email;

    @NotBlank(message = "Password is mandatory")
    @StrongPassword
    private String password;
}
