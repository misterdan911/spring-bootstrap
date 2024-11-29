package com.myspring.bootstrap.auth.validation;

import com.myspring.bootstrap.entity.User;
import com.myspring.bootstrap.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class EmailNotDuplicateValidator implements ConstraintValidator<EmailNotDuplicate, String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {

        Optional<User> rsUser = userRepository.findByEmail(email);
        if (rsUser.isPresent()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("The email '" + email + "' is already in use.").addConstraintViolation();
            return false;
        }

        return true;
    }
}
