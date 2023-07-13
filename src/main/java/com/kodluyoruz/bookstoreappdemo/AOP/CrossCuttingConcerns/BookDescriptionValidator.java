package com.kodluyoruz.bookstoreappdemo.AOP.CrossCuttingConcerns;

import com.kodluyoruz.bookstoreappdemo.AOP.Annotations.DescriptionMustBeUnique;
import com.kodluyoruz.bookstoreappdemo.Repository.BookRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookDescriptionValidator implements ConstraintValidator<DescriptionMustBeUnique,String> {

    private final BookRepository bookRepository;
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        int count = this.bookRepository.countByDescription(value);
        return count <= 0;
    }
}
