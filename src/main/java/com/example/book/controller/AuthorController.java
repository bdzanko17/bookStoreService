package com.example.book.controller;

import com.example.book.model.Author;
import com.example.book.model.Book;
import com.example.book.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
    private AuthorService service;

    @Autowired
    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @PostMapping("/addAuthor")
    public Author addAuthor(@RequestBody Author author){
       return service.save(author);
    }

//
//    @PostMapping("/addBookToAuthor")
//    public Author addBookToAuthor(@RequestParam("idAuthor") Long idAuthor, @RequestParam("idBook") Long idBook){
//        return service.addBookToAuthorr(idAuthor,idBook);
//    }

}
