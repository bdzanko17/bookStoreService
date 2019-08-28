package com.example.book.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pagee"/*, schema = "bookstore", catalog = ""*/)

public class Pagee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long ordinalNumber;
    private String content;

    @ManyToOne
    private Book book;

    public Pagee() {
    }

    public Pagee(Long ordinalNumber, String content) {
        this.ordinalNumber = ordinalNumber;
        this.content = content;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ordinal_number")
    public Long getOrdinalNumber() {
        return ordinalNumber;
    }

    public void setOrdinalNumber(Long ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
