package com.kodluyoruz.bookstoreappdemo.Dtos.Response.Book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponseDto {
    private int id;
    private String title;
    private String description;
    private String authorName;
    private  String category;
    private double price;
    private int unitInStock;

}
