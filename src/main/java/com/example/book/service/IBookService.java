package com.example.book.service;

import com.example.book.model.Author;
import com.example.book.model.Book;
import com.example.book.model.EntityInput.BookEntityInput;
import com.example.book.model.Page;

import java.util.List;

public interface IBookService {
    Book getBookByID(Long id);

    Book saveBook(BookEntityInput book);

    Book saveBook(Book book);

    List<Book> getBookList();

    List<Page> getPageList(String id);

    List<Author> getAuthorList(String id);

    void deleteBook(String id);
}
