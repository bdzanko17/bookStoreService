package com.example.book.service;

import com.example.book.model.Author;
import com.example.book.model.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAuthorService {
    public Author save(Author author);

    public void deleteAuthor(Long id);

    public Author changeAuthorName(Author author, long authorID);

    public ResponseEntity<Object> getAuthor(long authorID);

    public List<Author> getAllAuthors();

    public List<Book> getBooksFromAuthor(Long authorID);

    public void deleteAuthors();


}
