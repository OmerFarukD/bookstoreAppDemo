package com.kodluyoruz.bookstoreappdemo.AOP.Annotations;

import com.kodluyoruz.bookstoreappdemo.AOP.CrossCuttingConcerns.BookDescriptionValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = { BookDescriptionValidator.class})
public @interface DescriptionMustBeUnique {

    String message() default "Kitap Açıklaması benzersiz olmalı.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}