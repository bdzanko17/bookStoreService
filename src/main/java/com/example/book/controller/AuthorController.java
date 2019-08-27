package com.example.book.controller;

import com.example.book.model.Author;
import com.example.book.model.Book;
import com.example.book.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("deleteAuthor/{id}")
    public void deleteAuthor(@PathVariable String id){
        service.deleteAuthor(Long.parseLong(id));
    }

    @PostMapping("/changeAuthor/{id}")
    public Author  changeAuthorName(@RequestBody Author author, @PathVariable String id){
        return service.changeAuthorName(author,Long.parseLong(id));
    }

//
//    @PostMapping("/addBookToAuthor")
//    public Author addBookToAuthor(@RequestParam("idAuthor") Long idAuthor, @RequestParam("idBook") Long idBook){
//        return service.addBookToAuthorr(idAuthor,idBook);
//    }

}
