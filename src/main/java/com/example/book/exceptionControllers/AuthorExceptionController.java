package com.example.book.exceptionControllers;

import com.example.book.exceptions.AuthorNotFoundException;
import com.example.book.exceptions.BookAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AuthorExceptionController {

    @ExceptionHandler(value = AuthorNotFoundException.class)
    public ResponseEntity<Object> exception(AuthorNotFoundException exception) {
        return new ResponseEntity<>("Author with ID :"+ exception.getId() +" not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = IllegalStateException.class)
    public ResponseEntity<Object> exception(IllegalStateException exception) {
        return new ResponseEntity<>("Author already exist ", HttpStatus.BAD_REQUEST);
    }

}
