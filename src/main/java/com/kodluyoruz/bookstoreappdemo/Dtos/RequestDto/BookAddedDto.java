package com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookAddedDto {
    private String title;
    private String description;
    private String authorName;
    private  String category;
    private double price;
    private int unitInStock;

}
