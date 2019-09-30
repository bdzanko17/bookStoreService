package com.example.book.controller;

import com.example.book.model.Author;
import com.example.book.model.Book;
import com.example.book.model.dto.AuthorDTO;
import com.example.book.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/authors")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthorController {
    private IAuthorService service;

    @Autowired
    public AuthorController(IAuthorService service) {
        this.service = service;
    }

    @PostMapping
    public AuthorDTO addAuthor(@RequestBody Author author) {
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
    public AuthorDTO getAuthor(@PathVariable String id) {
        return service.getAuthor(Long.parseLong(id));
    }

    @GetMapping
    public ArrayList<AuthorDTO> getAuthors() {
        ArrayList<AuthorDTO> authors = service.getAllAuthors();
        return authors;
    }

    @GetMapping("getBooks/{id}")
    public List<Book> getBooksFromAuthor(@PathVariable String id) {
        return service.getBooksFromAuthor(Long.parseLong(id));
    }


}
