package com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Book;

import com.kodluyoruz.bookstoreappdemo.AOP.Annotations.DescriptionMustBeUnique;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUpdateDto {
    private int id;
    private String title;

    @DescriptionMustBeUnique
    private String description;
    private String authorName;
    private  String category;
    private double price;
    private int unitInStock;
}
