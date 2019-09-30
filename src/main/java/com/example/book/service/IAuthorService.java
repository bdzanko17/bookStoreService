package com.example.book.service;

import com.example.book.model.Author;
import com.example.book.model.Book;
import com.example.book.model.dto.AuthorDTO;

import java.util.ArrayList;
import java.util.List;

public interface IAuthorService {
    AuthorDTO save(Author author);

    void deleteAuthor(Long id);

    Author changeAuthorName(Author author, long authorID);

    AuthorDTO getAuthor(long authorID);

    ArrayList<AuthorDTO> getAllAuthors();

    List<Book> getBooksFromAuthor(Long authorID);

    void deleteAuthors();


}
