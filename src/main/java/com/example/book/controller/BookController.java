package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.model.EntityInput.BookEntityInput;
import com.example.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private IBookService service;

    @Autowired
    public BookController(IBookService service) {
        this.service = service;
    }

    @PostMapping("/saveBook")
    public Book save(@RequestBody BookEntityInput book) {
        return service.saveBook(book);
    }

    @GetMapping(path = "/{id}")
    public Book getBook(@PathVariable Long id){
        return service.getBookByID(id);
    }
    @GetMapping
    public List<Book> getBookList(){
        return service.getBookList();
    }

    @PutMapping("/updateBook/{id}")
    public Book updateBookByID(@RequestBody  BookEntityInput bookEntityInput,@PathVariable String ID ){
        return service.updateBook(bookEntityInput,Long.parseLong(ID));

    }







}
