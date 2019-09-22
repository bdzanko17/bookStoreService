package com.example.book.service;

import com.example.book.model.Author;
import com.example.book.model.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAuthorService {
    Author save(Author author);

    void deleteAuthor(Long id);

    Author changeAuthorName(Author author, long authorID);

    Author getAuthor(long authorID);

    List<Author> getAllAuthors();

    List<Book> getBooksFromAuthor(Long authorID);

    void deleteAuthors();


}
