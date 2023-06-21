package com.kodluyoruz.bookstoreappdemo.Controller;

import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.BookAddedDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.BookUpdateDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.BookUpdatePriceDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.BookUpdateTitleDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.Response.BookResponseDto;
import com.kodluyoruz.bookstoreappdemo.Entity.Book;
import com.kodluyoruz.bookstoreappdemo.Service.Contrats.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/books")
@RestController
@RequiredArgsConstructor
public class BooksController {

    private final BookService bookService;

    @PostMapping("/add")
    public void  add(@RequestBody BookAddedDto bookAddedDtoo){
        this.bookService.add(bookAddedDtoo);
    }

    @GetMapping("/kitapgetir")
    public List<BookResponseDto> kitaplariGetir(){
        return this.bookService.getAll();
    }


    @GetMapping("/getbyid")
    public BookResponseDto getById(@RequestParam int id){
        return this.bookService.getById(id);
    }

    @PostMapping("/delete")
    public void delete(@RequestParam int id){
       this.bookService.delete(id);
    }



    @PostMapping("/update")
    public void update(@RequestBody BookUpdateDto bookUpdateDto){
        this.bookService.update(bookUpdateDto);

    }

    @PostMapping("/updateForTitle")
    public void updateForTitle(@RequestBody BookUpdateTitleDto bookUpdateTitleDto){
        this.bookService.updateForTitle(bookUpdateTitleDto);
    }


    @PostMapping("/updateForPrice")
    public void updateForPrice(@RequestBody BookUpdatePriceDto bookUpdatePriceDto){
        this.bookService.updateForPrice(bookUpdatePriceDto);
    }

}
