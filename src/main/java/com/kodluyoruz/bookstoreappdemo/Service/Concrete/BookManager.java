package com.kodluyoruz.bookstoreappdemo.Service.Concrete;

import com.kodluyoruz.bookstoreappdemo.AOP.Annotations.Logging.LoggerToDbForResult;
import com.kodluyoruz.bookstoreappdemo.Core.Exception.BookNotFoundExceptionById;
import com.kodluyoruz.bookstoreappdemo.Core.Exception.BookNotFoundExceptionByTitle;
import com.kodluyoruz.bookstoreappdemo.Core.Exception.BusinessException;
import com.kodluyoruz.bookstoreappdemo.Core.Results.*;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Book.BookAddedDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Book.BookUpdateDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Book.BookUpdatePriceDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Book.BookUpdateTitleDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.Response.Book.BookResponseDto;
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
    @LoggerToDbForResult
    public Result add(BookAddedDto bookAddedDto) {
        //Nutuk1234
        Book book=this.addRequestToEntity(bookAddedDto);
       Optional<Book> checkBook= this.bookRepository.getByTitle(book.getTitle());
        if (checkBook.isPresent()){
            //throw new BusinessException("Kitap adı benzersiz olmalı ");
           return new ErrorResult("Kitap adı benzersiz olmalı ");
        }
        this.bookRepository.save(book);
        return new SuccessResult("Kitap başarıyla Eklendi.");
    }

// checked ve unchecked

    @Override
    public DataResult<List<BookResponseDto>> getAll() {
        List<Book> books = this.bookRepository.findAll();
        List<BookResponseDto> dtoList=this.listEntityToResponseList(books);
        if (dtoList.isEmpty()){
            return new ErrorDataResult<>("Kitaplar bulunamadı");
        }

        return new SuccessDataResult<>(dtoList,"Kitaplar Listelendi.");
    }



    @Override
    public DataResult<BookResponseDto> getById(int id) {
       Optional <Book> book = this.bookRepository.findById(id);
       if (book.isEmpty()){
           return new ErrorDataResult<>("Aradığınız Kriterde Kitap Bulunamadı");
       }

        BookResponseDto dto=this.entityToResponse(book.get());
        return new SuccessDataResult<>(dto,"Kitap Getirildi.");
    }

    @Override

    // Book:{ id: 1 ,title:"Matematiğin aydınlık dünyası
    @LoggerToDbForResult
    public DataResult<BookResponseDto> update(BookUpdateDto bookUpdateDto) {
        Book book=updateRequestToEntity(bookUpdateDto);
        this.bookRepository.save(book);
        BookResponseDto bookResponseDto=entityToResponse(book);
        return new SuccessDataResult<>(bookResponseDto,"Kitap Güncellendi.");
    }
    @Override
    public DataResult<BookResponseDto> delete(int id) {
        Book book=this.bookRepository.findById(id).orElseThrow(()-> new BookNotFoundExceptionById(id));
        this.bookRepository.delete(book);
        BookResponseDto bookResponseDto=entityToResponse(book);
        return new SuccessDataResult<>(bookResponseDto,"Kitap Slindi");
    }

    @Override
    public Result updateForTitle(BookUpdateTitleDto bookUpdateTitleDto) {
      Book book=updateTitleDtoToEntity(bookUpdateTitleDto);
      if (book == null){
          return new ErrorResult("Kitap bulunamadı");
      }
        this.bookRepository.save(book);
      return new SuccessResult("Kitabın Başlığı güncellendi");
    }



    @Override
    public Result updateForPrice(BookUpdatePriceDto bookUpdatePriceDto) {
        Book book=this.updatePriceDtoToEntity(bookUpdatePriceDto);
        if (book == null){
            return new ErrorResult("Kitap bulunamadı");
        }
        this.bookRepository.save(book);
        return new SuccessResult("Kitabın değeri güncellendi.");
    }


    @Override
    public DataResult<BookResponseDto> getByTitle(String title) {
        Book book=this.bookRepository.getByTitle(title).orElseThrow(()-> new BookNotFoundExceptionByTitle(title));
        BookResponseDto bookResponseDto=this.entityToResponse(book);
        return new SuccessDataResult<>(bookResponseDto,"Başlığa göre ürün getirildi.");
    }

    // Converter Methods
    private Book updateTitleDtoToEntity(BookUpdateTitleDto bookUpdateTitleDto){
        Book book= this.bookRepository.findById(bookUpdateTitleDto.getId()).orElseThrow(()-> new BusinessException("Kitap bulunamadı"));
        book.setTitle(bookUpdateTitleDto.getTitle());
        return book;
    }

    private Book updatePriceDtoToEntity(BookUpdatePriceDto bookUpdatePriceDto){
        Book book=this.bookRepository.findById(bookUpdatePriceDto.getId()).orElseThrow(()-> new BusinessException("Kitap bulunamadı"));
        book.setPrice(bookUpdatePriceDto.getPrice());
        return book;
    }
    private Book updateRequestToEntity(BookUpdateDto bookUpdateDto){
        Book book=this.bookRepository.findById(bookUpdateDto.getId()).orElseThrow(()-> new BookNotFoundExceptionById(bookUpdateDto.getId()));
        book.setDescription(bookUpdateDto.getDescription());
        book.setTitle(bookUpdateDto.getTitle());
      //  book.setAuthorName(bookUpdateDto.getAuthorName());
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
      //  dto.setCategory(book.getCategory());
       // dto.setAuthorName(book.getAuthorName());
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
         //   dto.setCategory(book.getCategory());
           // dto.setAuthorName(book.getAuthorName());
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
     //   book.setCategory(bookAddedDto.getCategory());
       // book.setAuthorName(bookAddedDto.getAuthorName());
        book.setUnitInStock(bookAddedDto.getUnitInStock());
        return book;
    }
}
