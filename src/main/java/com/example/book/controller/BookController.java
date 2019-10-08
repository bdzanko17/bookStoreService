package com.example.book.controller;

import com.example.book.model.Author;
import com.example.book.model.Book;
import com.example.book.model.EntityInput.BookEntityInput;
import com.example.book.model.Page;
import com.example.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

    private IBookService service;

    @Autowired
    public BookController(IBookService service) {
        this.service = service;
    }

    @PostMapping
    public Book save(@RequestBody BookEntityInput book) {
        return service.saveBook(book);
    }

    @GetMapping(path = "/{id}")
    public Book getBook(@PathVariable Long id) {
        return service.getBookByID(id);
    }

    @GetMapping("/getPages/{id}")
    public List<Page> getPageList(@PathVariable String id) {
        return service.getPageList(id);
    }

    @GetMapping
    public List<Book> getBookList() {
        return service.getBookList();
    }

    @GetMapping("/getAuthors/{id}")
    public List<Author> getAuthorsList(@PathVariable String id) {
        return service.getAuthorList(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        service.deleteBook(id);
    }


}
