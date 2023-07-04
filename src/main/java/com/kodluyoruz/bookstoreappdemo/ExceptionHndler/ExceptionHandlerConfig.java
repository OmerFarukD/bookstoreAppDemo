package com.kodluyoruz.bookstoreappdemo.ExceptionHndler;

import com.kodluyoruz.bookstoreappdemo.Core.Exception.BookNotFoundExceptionById;
import com.kodluyoruz.bookstoreappdemo.Core.Exception.BookNotFoundExceptionByTitle;
import com.kodluyoruz.bookstoreappdemo.Core.Exception.BusinessException;
import com.kodluyoruz.bookstoreappdemo.Core.Results.ErrorResult;
import com.kodluyoruz.bookstoreappdemo.Core.Results.Result;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerConfig {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult handleBusinessException( BusinessException businessException){
        return new ErrorResult(businessException.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(BookNotFoundExceptionById.class)
    public ResponseEntity<String> handleBookNotFoundExceptionById(BookNotFoundExceptionById e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
    @ExceptionHandler(BookNotFoundExceptionByTitle.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult handleBookNotFoundExceptionByTitle(BookNotFoundExceptionByTitle e){
        return new ErrorResult(e.getMessage());
    }

}
