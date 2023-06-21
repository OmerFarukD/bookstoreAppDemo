package com.kodluyoruz.bookstoreappdemo.Service.Contrats;

import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.BookAddedDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.BookUpdateDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.BookUpdatePriceDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.BookUpdateTitleDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.Response.BookResponseDto;
import com.kodluyoruz.bookstoreappdemo.Entity.Book;

import java.util.List;
// Onion + Cqrs
// SOLID
// I harfi Interfaceylerin ayrışması
public interface BookService {
    void  add(BookAddedDto bookAddedDto);
    List<BookResponseDto> getAll();
    BookResponseDto getById(int id);
    void update(BookUpdateDto bookUpdateDto);
    void delete(int id);

    void updateForTitle(BookUpdateTitleDto bookUpdateTitleDto);
    void updateForPrice(BookUpdatePriceDto bookUpdatePriceDto);
    BookResponseDto getByTitle(String title);
}
