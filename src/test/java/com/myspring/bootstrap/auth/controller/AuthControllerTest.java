package com.myspring.bootstrap.auth.controller;

import com.myspring.bootstrap.auth.dto.SignUpDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myspring.bootstrap.shared.response.ResponseSuccess;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testSignUpSuccess() throws Exception {

        SignUpDto signUpDto = new SignUpDto();
        signUpDto.setName("Yusmi Arini");
        signUpDto.setUsername("yusmi");
        signUpDto.setEmail("yusmi@gmail.com");
        signUpDto.setPassword("12345678Aa!");

        mockMvc.perform(
                post("/api/auth/signup")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(signUpDto))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            ResponseSuccess<SignUpDto> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            assertEquals("yusmi", response.getData().getUsername());
        });
    }
  
}