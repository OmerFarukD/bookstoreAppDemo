package com.kodluyoruz.bookstoreappdemo.Service.Contrats;

import com.kodluyoruz.bookstoreappdemo.Core.Results.DataResult;
import com.kodluyoruz.bookstoreappdemo.Core.Results.Result;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Book.BookAddedDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Book.BookUpdateDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Book.BookUpdatePriceDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Book.BookUpdateTitleDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.Response.Book.BookResponseDto;

import java.util.List;
// Onion + Cqrs
// SOLID
// I harfi Interfaceylerin ayrışması
public interface BookService {
    Result add(BookAddedDto bookAddedDto);
    DataResult<List<BookResponseDto>> getAll();
    DataResult<BookResponseDto> getById(int id);
    DataResult<BookResponseDto> update(BookUpdateDto bookUpdateDto);
    DataResult<BookResponseDto> delete(int id);
    Result updateForTitle(BookUpdateTitleDto bookUpdateTitleDto);
    Result updateForPrice(BookUpdatePriceDto bookUpdatePriceDto);
    DataResult<BookResponseDto> getByTitle(String title);
}
