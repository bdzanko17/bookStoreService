package com.example.book.service;

import com.example.book.model.Book;
import com.example.book.model.EntityInput.BookEntityInput;

import java.util.List;

public interface IBookService {
    public Book getBookByID(Long id);

    public Book saveBook(BookEntityInput book);

    public List<Book> getBookList();

}
