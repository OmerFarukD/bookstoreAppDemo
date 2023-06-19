package com.kodluyoruz.bookstoreappdemo.Controller;

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
    public void  add(@RequestBody Book book){
        this.bookService.add(book);
    }

    @GetMapping("/kitapgetir")
    public List<Book> kitaplariGetir(){
        return this.bookService.getAll();
    }


    @GetMapping("/getbyid")
    public Book getById(@RequestParam int id){
        return this.bookService.getById(id);
    }

    @PostMapping("/delete")
    public void delete(@RequestParam int id){
       this.bookService.delete(id);
    }
}
