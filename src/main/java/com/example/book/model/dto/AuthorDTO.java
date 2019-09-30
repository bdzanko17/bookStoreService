package com.example.book.model.dto;

import com.example.book.model.Author;
import com.example.book.model.Book;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class AuthorDTO {
    private Long id;
    private String name;
    private List<Book> books = new ArrayList<>();

    public AuthorDTO() {
    }

    public AuthorDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public AuthorDTO(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.books = author.getBooks();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
