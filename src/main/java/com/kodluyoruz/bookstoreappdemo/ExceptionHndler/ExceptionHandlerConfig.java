package com.kodluyoruz.bookstoreappdemo.ExceptionHndler;

import com.kodluyoruz.bookstoreappdemo.Core.Exception.BusinessException;
import com.kodluyoruz.bookstoreappdemo.Core.Results.ErrorResult;
import com.kodluyoruz.bookstoreappdemo.Core.Results.Result;
import org.springframework.http.HttpStatus;
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
}
