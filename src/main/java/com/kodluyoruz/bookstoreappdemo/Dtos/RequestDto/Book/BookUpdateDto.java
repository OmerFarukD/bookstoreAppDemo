package com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUpdateDto {
    private int id;
    private String title;
    private String description;
    private String authorName;
    private  String category;
    private double price;
    private int unitInStock;
}
