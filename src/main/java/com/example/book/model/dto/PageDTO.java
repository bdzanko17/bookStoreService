package com.example.book.model.dto;

import com.example.book.model.Book;
import com.example.book.model.Page;

public class PageDTO {
    private Long id;
    private Long ordinalNumber;
    private String content;
    private Book book;

    public PageDTO() {
    }
    public PageDTO(Page page){
        this.id=page.getId();
        this.ordinalNumber= page.getOrdinalNumber();
        this.content= page.getContent();
        this.book = page.getBook();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrdinalNumber() {
        return ordinalNumber;
    }

    public void setOrdinalNumber(Long ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
    }

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
