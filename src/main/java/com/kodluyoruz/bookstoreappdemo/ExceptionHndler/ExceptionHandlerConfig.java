package com.kodluyoruz.bookstoreappdemo.ExceptionHndler;
import com.kodluyoruz.bookstoreappdemo.Core.Exception.BookNotFoundExceptionById;
import com.kodluyoruz.bookstoreappdemo.Core.Exception.BookNotFoundExceptionByTitle;
import com.kodluyoruz.bookstoreappdemo.Core.Exception.BusinessException;
import com.kodluyoruz.bookstoreappdemo.Core.Results.ErrorDataResult;
import com.kodluyoruz.bookstoreappdemo.Core.Results.ErrorResult;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ErrorResult  handleBookNotFoundExceptionByTitle(BookNotFoundExceptionByTitle e){
        return new ErrorResult(e.getMessage());
    }

/*    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<List<String>> handleValidationExceptionHandler(MethodArgumentNotValidException ex){
        List<String> validationErrors = new ArrayList<>();
        if (!ex.getFieldErrors().isEmpty()){
            for (FieldError fieldError : ex.getFieldErrors()){
                validationErrors.add(fieldError.getDefaultMessage());
            }
        }
        return new ErrorDataResult<>(validationErrors,"Validasyon kuralları.");
    }*/
@ExceptionHandler(MethodArgumentNotValidException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public ErrorDataResult<Map<String,String>> handleValidationExceptionHandler(MethodArgumentNotValidException ex){
  Map<String,String> dictionary = new HashMap<>();
  if (!ex.getFieldErrors().isEmpty()){
      for (FieldError fieldError : ex.getFieldErrors()){
          dictionary.put(fieldError.getField(),fieldError.getDefaultMessage());
      }
  }
  return new ErrorDataResult<>(dictionary,"Validasyon Kuralları");
}

}
