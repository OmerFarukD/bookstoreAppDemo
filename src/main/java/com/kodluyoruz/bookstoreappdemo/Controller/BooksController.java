package com.kodluyoruz.bookstoreappdemo.Controller;

import com.kodluyoruz.bookstoreappdemo.Core.Results.Result;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Book.BookAddedDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Book.BookUpdateDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Book.BookUpdatePriceDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Book.BookUpdateTitleDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.Response.Book.BookResponseDto;
import com.kodluyoruz.bookstoreappdemo.Service.Contrats.BookService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/books")
@RestController
@RequiredArgsConstructor
public class BooksController {

    private final BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody BookAddedDto bookAddedDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.bookService.add(bookAddedDto));
    }

    @GetMapping("/kitapgetir")
    public List<BookResponseDto> kitaplariGetir(){
        return this.bookService.getAll();
    }


    @GetMapping("/getbyid")
    public ResponseEntity<?> getById(@RequestParam int id){
            return ResponseEntity.status(HttpStatus.OK).body(this.bookService.getById(id));
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

    @GetMapping("/getbytitle")
    public ResponseEntity<BookResponseDto> getByTitle(String title){
        return ResponseEntity.status(HttpStatus.OK).body(this.bookService.getByTitle(title));
    }

}
