//package com.example.book.model;
//
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Entity
//@Table(name = "pagee"/*, schema = "bookstore", catalog = ""*/)
//
//public class Pagee implements Serializable {
//
//    private Long id;
//    private Long ordinalNumber;
//    private String content;
//    @JsonManagedReference
//    @ManyToOne()
//    @JoinColumn(name = "book_id")
//    private Long bookId;
//
//    public Pagee() {
//    }
//
//    public Pagee(Long ordinalNumber, String content) {
//        this.ordinalNumber = ordinalNumber;
//        this.content = content;
//    }
//
//    public Pagee(Long ordinalNumber, String content, Long bookId) {
//        this.ordinalNumber = ordinalNumber;
//        this.content = content;
//        this.bookId = bookId;
//    }
//
//    public Pagee(Long id, Long ordinalNumber, String content, Long bookId) {
//        this.id = id;
//        this.ordinalNumber = ordinalNumber;
//        this.content = content;
//        this.bookId = bookId;
//    }
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    @Basic
//    @Column(name = "ordinal_number")
//    public Long getOrdinalNumber() {
//        return ordinalNumber;
//    }
//
//    public void setOrdinalNumber(Long ordinalNumber) {
//        this.ordinalNumber = ordinalNumber;
//    }
//
//    @Basic
//    @Column(name = "content")
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//
//    public Long getBookId() {
//        return bookId;
//    }
//
//    public void setBookId(Long bookId) {
//        this.bookId = bookId;
//    }
//}
