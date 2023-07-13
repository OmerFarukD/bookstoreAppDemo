package com.kodluyoruz.bookstoreappdemo.Controller;

import com.kodluyoruz.bookstoreappdemo.Core.Results.DataResult;
import com.kodluyoruz.bookstoreappdemo.Core.Results.Result;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Book.BookAddedDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Book.BookUpdateDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Book.BookUpdatePriceDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.RequestDto.Book.BookUpdateTitleDto;
import com.kodluyoruz.bookstoreappdemo.Dtos.Response.Book.BookResponseDto;
import com.kodluyoruz.bookstoreappdemo.Service.Contrats.BookService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
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
    public ResponseEntity<Result> add(@Valid @RequestBody BookAddedDto bookAddedDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.bookService.add(bookAddedDto));
    }

    @GetMapping("/kitapgetir")
    public ResponseEntity<DataResult<List<BookResponseDto>>> kitaplariGetir(){
        return ResponseEntity.status(HttpStatus.OK).body(this.bookService.getAll());
    }


    @GetMapping("/getbyid")
    public ResponseEntity<DataResult<BookResponseDto>> getById(@RequestParam int id){
            return ResponseEntity.status(HttpStatus.OK).body(this.bookService.getById(id));
    }

    @PostMapping("/delete")
    public ResponseEntity<Result> delete(@RequestParam int id) {

       return ResponseEntity.status(HttpStatus.OK).body(this.bookService.delete(id));

    }

    @PostMapping("/update")
    public ResponseEntity<Result> update(@RequestBody BookUpdateDto bookUpdateDto){
        return ResponseEntity.status(HttpStatus.OK).body(this.bookService.update(bookUpdateDto));

    }

    @PostMapping("/updateForTitle")
    public ResponseEntity<Result> updateForTitle(@RequestBody BookUpdateTitleDto bookUpdateTitleDto){
       return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.bookService.updateForTitle(bookUpdateTitleDto));
    }
    @PostMapping("/updateForPrice")
    public Result updateForPrice(@RequestBody BookUpdatePriceDto bookUpdatePriceDto){
       return this.bookService.updateForPrice(bookUpdatePriceDto);
    }

    @GetMapping("/getbytitle")
    public ResponseEntity<DataResult<BookResponseDto>> getByTitle(String title){
        return ResponseEntity.status(HttpStatus.OK).body(this.bookService.getByTitle(title));
    }

}
