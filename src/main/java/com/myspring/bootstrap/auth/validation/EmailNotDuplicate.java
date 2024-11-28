package com.myspring.bootstrap.auth.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = EmailNotDuplicateValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EmailNotDuplicate {

    String message() default "Duplicate email detected";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}


