package com.kodluyoruz.bookstoreappdemo.Controller;

import com.kodluyoruz.bookstoreappdemo.Core.Results.Result;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Book.BookAddedDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Book.BookUpdateDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Book.BookUpdatePriceDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Book.BookUpdateTitleDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.Response.Book.BookResponseDto;
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
    public Result add(@RequestBody BookAddedDto bookAddedDto){

        return this.bookService.add(bookAddedDto);
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
    public BookResponseDto delete(@RequestParam int id) {

       return this.bookService.delete(id);

    }



    @PostMapping("/update")
    public BookResponseDto update(@RequestBody BookUpdateDto bookUpdateDto){
      return this.bookService.update(bookUpdateDto);

    }

    @PostMapping("/updateForTitle")
    public Result updateForTitle(@RequestBody BookUpdateTitleDto bookUpdateTitleDto){
       return this.bookService.updateForTitle(bookUpdateTitleDto);
    }
    @PostMapping("/updateForPrice")
    public Result updateForPrice(@RequestBody BookUpdatePriceDto bookUpdatePriceDto){
       return this.bookService.updateForPrice(bookUpdatePriceDto);
    }

}
