package com.example.book.exceptionControllers;

import com.example.book.exceptions.AuthorNotFoundException;
import com.example.book.exceptions.PageAlreadyExist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PageExceptionController {
    @ExceptionHandler(value = PageAlreadyExist.class)
    public ResponseEntity<Object> exception(PageAlreadyExist exception) {
        return new ResponseEntity<>("Page already exist ", HttpStatus.BAD_REQUEST);
    }
}
