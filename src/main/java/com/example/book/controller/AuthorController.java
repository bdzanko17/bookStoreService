package com.example.book.controller;

import com.example.book.model.Author;
import com.example.book.model.Book;
import com.example.book.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private IAuthorService service;

    @Autowired
    public AuthorController(IAuthorService service) {
        this.service = service;
    }

    @PostMapping
    public Author addAuthor(@RequestBody Author author) {
        return service.save(author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable String id) {
        service.deleteAuthor(Long.parseLong(id));
    }

    @DeleteMapping
    public void deleteAuthors() {
        service.deleteAuthors();
    }

    @PutMapping("/changeName/{id}")
    public Author changeAuthorName(@RequestBody Author author, @PathVariable String id) {
        return service.changeAuthorName(author, Long.parseLong(id));
    }

    @GetMapping(value = "/{id}")
    public Author getAuthor(@PathVariable String id) {
        return service.getAuthor(Long.parseLong(id));
    }

    @GetMapping
    public List<Author> getAuthors() {
        List<Author> authors = service.getAllAuthors();
        return authors;
    }

    @GetMapping("getBooks/{id}")
    public List<Book> getBooksFromAuthor(@PathVariable String id) {
        return service.getBooksFromAuthor(Long.parseLong(id));
    }


}
