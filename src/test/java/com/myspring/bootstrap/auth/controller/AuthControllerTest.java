package com.myspring.bootstrap.auth.controller;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthControllerTest {

    @Autowired
    AuthController authController;

    @Test
    void contextLoads() throws Exception {
        assertThat(authController).isNotNull();
    }
}
