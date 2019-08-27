package com.example.book.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book"/*, schema = "bookstore"*/)

public class Book implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String genre;

    @ManyToMany
    private List<Author> authors;

    public Book() {
    }

    public Book(String tittle, String genre) {
        this.title = tittle;
        this.genre = genre;
    }




    public java.lang.Long getId() {
        return id;
    }
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
