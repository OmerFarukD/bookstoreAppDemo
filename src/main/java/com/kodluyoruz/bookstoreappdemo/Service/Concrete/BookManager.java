package com.kodluyoruz.bookstoreappdemo.Service.Concrete;

import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.BookAddedDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.BookUpdateDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.BookUpdatePriceDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.BookUpdateTitleDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.Response.BookResponseDto;
import com.kodluyoruz.bookstoreappdemo.Entity.Book;
import com.kodluyoruz.bookstoreappdemo.Repository.BookRepository;
import com.kodluyoruz.bookstoreappdemo.Service.Contrats.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Data Transfer Object
// product -> id vs vs müşteri_komisyonu , satıcı_komisyonu,

@RequiredArgsConstructor
@Service
public class BookManager implements BookService {

    private final BookRepository bookRepository;

    @Override
    public void add(BookAddedDto bookAddedDto) {
        Book book = new Book();
        book.setTitle(bookAddedDto.getTitle());
        book.setDescription(bookAddedDto.getDescription());
        book.setPrice(bookAddedDto.getPrice());
        book.setCategory(bookAddedDto.getCategory());
        book.setAuthorName(bookAddedDto.getAuthorName());
        book.setUnitInStock(bookAddedDto.getUnitInStock());
        this.bookRepository.save(book);
    }

    @Override
    public List<BookResponseDto> getAll() {
        List<Book> books = this.bookRepository.findAll();
        List<BookResponseDto> dtoList = new ArrayList<>();
        for (Book book : books) {
            BookResponseDto dto = new BookResponseDto();
            dto.setId(book.getId());
            dto.setDescription(book.getDescription());
            dto.setTitle(book.getTitle());
            dto.setPrice(book.getPrice());
            dto.setCategory(book.getCategory());
            dto.setAuthorName(book.getAuthorName());
            dto.setUnitInStock(book.getUnitInStock());
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public BookResponseDto getById(int id) {
        Book book = this.bookRepository.getById(id);
        BookResponseDto dto = new BookResponseDto();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setDescription(book.getDescription());
        dto.setPrice(book.getPrice());
        dto.setCategory(book.getCategory());
        dto.setAuthorName(book.getAuthorName());
        dto.setUnitInStock(book.getUnitInStock());

        return dto;
    }

    @Override

    // Book:{ id: 1 ,title:"Matematiğin aydınlık dünyası ,
    // AutoMapper
    //Mapstruct
    public void update(BookUpdateDto bookUpdateDto) {
        Book book=this.bookRepository.getById(bookUpdateDto.getId());
        book.setDescription(bookUpdateDto.getDescription());
        book.setTitle(bookUpdateDto.getTitle());
        book.setAuthorName(bookUpdateDto.getAuthorName());
        book.setPrice(bookUpdateDto.getPrice());
        book.setUnitInStock(bookUpdateDto.getUnitInStock());
        this.bookRepository.save(book);
    }

    @Override
    public void delete(int id) {
        Book book=this.bookRepository.getById(id);
        this.bookRepository.delete(book);
    }

    @Override
    public void updateForTitle(BookUpdateTitleDto bookUpdateTitleDto) {
        Book book= this.bookRepository.getById(bookUpdateTitleDto.getId());
        book.setTitle(bookUpdateTitleDto.getTitle());
        this.bookRepository.save(book);
    }

    @Override
    public void updateForPrice(BookUpdatePriceDto bookUpdatePriceDto) {
        Book book=this.bookRepository.getById(bookUpdatePriceDto.getId());
        book.setPrice(bookUpdatePriceDto.getPrice());
        this.bookRepository.save(book);
    }

    @Override
    public BookResponseDto getByTitle(String title) {
        Book book=this.bookRepository.getByTitle(title);
        BookResponseDto dto= new BookResponseDto();
        dto.setId(book.getId());
        dto.setDescription(book.getDescription());
        dto.setPrice(book.getPrice());
        dto.setUnitInStock(book.getUnitInStock());
        dto.setCategory(book.getCategory());
        dto.setAuthorName(book.getAuthorName());
        return dto;
    }
}
