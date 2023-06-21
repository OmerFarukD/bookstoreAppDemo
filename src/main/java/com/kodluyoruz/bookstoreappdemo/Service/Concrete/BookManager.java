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

// Data Transfer Object
// product -> id vs vs müşteri_komisyonu , satıcı_komisyonu,

@RequiredArgsConstructor
@Service
public class BookManager implements BookService {

    private final BookRepository bookRepository;

    @Override
    public void add(BookAddedDto bookAddedDto) {

        Book book=this.addRequestToEntity(bookAddedDto);
        this.bookRepository.save(book);
    }



    @Override
    public List<BookResponseDto> getAll() {
        List<Book> books = this.bookRepository.findAll();
        List<BookResponseDto> dtoList=this.listEntityToResponseList(books);
        return dtoList;

    }



    @Override
    public BookResponseDto getById(int id) {
        Book book = this.bookRepository.getById(id);
        BookResponseDto dto=this.entityToResponse(book);
        return dto;
    }



    @Override

    // Book:{ id: 1 ,title:"Matematiğin aydınlık dünyası
    public BookResponseDto update(BookUpdateDto bookUpdateDto) {
        Book book=updateRequestToEntity(bookUpdateDto);
        this.bookRepository.save(book);
        BookResponseDto bookResponseDto=entityToResponse(book);
        return bookResponseDto;
    }




    @Override
    public BookResponseDto delete(int id) {
        Book book=this.bookRepository.getById(id);
        this.bookRepository.delete(book);
        BookResponseDto bookResponseDto=entityToResponse(book);
        return bookResponseDto;
    }

    @Override
    public void updateForTitle(BookUpdateTitleDto bookUpdateTitleDto) {
      Book book=updateTitleDtoToEntity(bookUpdateTitleDto);
        this.bookRepository.save(book);
    }



    @Override
    public void updateForPrice(BookUpdatePriceDto bookUpdatePriceDto) {
    Book book=this.updatePriceDtoToEntity(bookUpdatePriceDto);
        this.bookRepository.save(book);
    }


    @Override
    public BookResponseDto getByTitle(String title) {
        Book book=this.bookRepository.getByTitle(title);
        BookResponseDto bookResponseDto=this.entityToResponse(book);
        return bookResponseDto;

    }

    // Converter Methods
    private Book updateTitleDtoToEntity(BookUpdateTitleDto bookUpdateTitleDto){
        Book book= this.bookRepository.getById(bookUpdateTitleDto.getId());
        book.setTitle(bookUpdateTitleDto.getTitle());
        return book;
    }

    private Book updatePriceDtoToEntity(BookUpdatePriceDto bookUpdatePriceDto){
        Book book=this.bookRepository.getById(bookUpdatePriceDto.getId());
        book.setPrice(bookUpdatePriceDto.getPrice());
        return book;
    }
    private Book updateRequestToEntity(BookUpdateDto bookUpdateDto){
        Book book=this.bookRepository.getById(bookUpdateDto.getId());
        book.setDescription(bookUpdateDto.getDescription());
        book.setTitle(bookUpdateDto.getTitle());
        book.setAuthorName(bookUpdateDto.getAuthorName());
        book.setPrice(bookUpdateDto.getPrice());
        book.setUnitInStock(bookUpdateDto.getUnitInStock());
        return book;
    }
    private BookResponseDto entityToResponse(Book book){
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

    private List<BookResponseDto> listEntityToResponseList(List<Book> books){
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
    private Book addRequestToEntity(BookAddedDto bookAddedDto){
        Book book = new Book();
        book.setTitle(bookAddedDto.getTitle());
        book.setDescription(bookAddedDto.getDescription());
        book.setPrice(bookAddedDto.getPrice());
        book.setCategory(bookAddedDto.getCategory());
        book.setAuthorName(bookAddedDto.getAuthorName());
        book.setUnitInStock(bookAddedDto.getUnitInStock());
        return book;
    }
}
