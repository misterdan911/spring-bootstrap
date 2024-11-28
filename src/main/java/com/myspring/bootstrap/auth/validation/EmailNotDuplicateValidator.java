package com.myspring.bootstrap.auth.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailNotDuplicateValidator implements ConstraintValidator<EmailNotDuplicate, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // check if string contains at least one digit, one lowercase letter, one uppercase letter, one special character and 8 characters long
        // return value.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!*()]).{8,}$");
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("The email '" + value + "' is already in use.").addConstraintViolation();
        return false;
    }

}
