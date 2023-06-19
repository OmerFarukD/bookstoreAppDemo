package com.kodluyoruz.bookstoreappdemo.Service.Concrete;

import com.kodluyoruz.bookstoreappdemo.Entity.Book;
import com.kodluyoruz.bookstoreappdemo.Repository.BookRepository;
import com.kodluyoruz.bookstoreappdemo.Service.Contrats.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookManager implements BookService {

    private final BookRepository bookRepository;

    @Override
    public void add(Book book) {
        this.bookRepository.save(book);

    }

    @Override
    public List<Book> getAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book getById(int id) {
        Optional<Book> book= this.bookRepository.findById(id);
       if (book.isEmpty()) {
           return null;
       }
        return book.get();
    }

    @Override
    public void update(Book book) {
        this.bookRepository.save(book);
    }
    @Override
    public void delete(int id) {
        Book book=this.bookRepository.getById(id);
        this.bookRepository.delete(book);
    }

    @Override
    public Book getByTitle(String title) {
        List<Book> books= this.bookRepository.findAll();

        for (Book book: books){
            if (book.getTitle().equals(title)){
                return book;
            }
        }
        return null;
    }
}
