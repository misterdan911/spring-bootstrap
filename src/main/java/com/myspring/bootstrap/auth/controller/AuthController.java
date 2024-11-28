package com.myspring.bootstrap.auth.controller;

import com.myspring.bootstrap.auth.dto.SignUpDto;
import com.myspring.bootstrap.auth.service.AuthService;
import com.myspring.bootstrap.shared.response.ResponseFail;
import com.myspring.bootstrap.shared.response.ResponseSuccess;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.antlr.v4.runtime.atn.ErrorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    public AuthService authService;

    // @ModelAttribute
    @PostMapping(value = "/api/auth/signup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpDto signUpDto)
    {
        authService.signUp(signUpDto);

        ResponseSuccess response = new ResponseSuccess(signUpDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseFail handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ResponseFail response = new ResponseFail(errors);
        return response;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseFail duplicateEmailException(HttpServletRequest req, DataIntegrityViolationException e) {
        ResponseFail response = new ResponseFail(e.getMessage());
        return response;
    }
}
