package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.model.EntityInput.BookEntityInput;
import com.example.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping("/saveBook")
    public Book save(@RequestBody BookEntityInput book) {
        return service.saveBook(book);
    }

    @GetMapping(path = "/book/{id}")
    public Book getBook(@PathVariable Long id){
        return service.getBookByID(id);
    }
    @GetMapping
    public List<Book> getBookList(){
        return service.getBookList();
    }







//    @PutMapping(path = "/{id}")
//    public Book addPageToBook(@PathVariable Long id){
//        return service.get
//    }

//    @GetMapping(path = "/{id}")
//    public AAAA find(@PathVariable Long id){
//        return service.getById(id);
//    }


}
