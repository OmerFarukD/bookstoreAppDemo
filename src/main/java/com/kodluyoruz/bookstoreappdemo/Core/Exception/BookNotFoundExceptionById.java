package com.kodluyoruz.bookstoreappdemo.Core.Exception;

public class BookNotFoundExceptionById extends RuntimeException{
    public BookNotFoundExceptionById(int id) {
        super("Id : "+id+" ye ait kitap bulunamadı");
    }
}
