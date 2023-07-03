package com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Book;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUpdatePriceDto {
    private int id;
    private double price;
}
