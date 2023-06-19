package com.kodluyoruz.bookstoreappdemo.Service.Contrats;

import com.kodluyoruz.bookstoreappdemo.Entity.Book;

import java.util.List;

// SOLID
// I harfi Interfaceylerin ayrışması
public interface BookService {
    void  add(Book book);
    List<Book> getAll();
    Book getById(int id);
    void update(Book book);
    void delete(int id);

    Book getByTitle(String title);
}
