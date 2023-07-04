package com.kodluyoruz.bookstoreappdemo.Core.Exception;

public class BookNotFoundExceptionByTitle extends  RuntimeException{
    public BookNotFoundExceptionByTitle(String title) {
        super("Title: "+title+" not found.");
    }
}
