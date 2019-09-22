package com.example.book.service.impl;

import com.example.book.exceptions.AuthorAlreadyExistException;
import com.example.book.exceptions.AuthorNotFoundException;
import com.example.book.model.Author;
import com.example.book.model.Book;
import com.example.book.repository.AuthorRepository;
import com.example.book.repository.BookRepository;
import com.example.book.service.IAuthorService;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements IAuthorService {
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public Author save(Author author) {
        Optional<Author> authorOptional = authorRepository.getAuthorEntityByName(author.getName());
        if (authorOptional.isPresent()) {
            throw new AuthorAlreadyExistException();
        }
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        authorRepository.delete(authorRepository.getOne(id));
    }

    public Author changeAuthorName(Author author, long authorID) {
        Optional<Author> authorOptional = authorRepository.getAuthorEntityById(authorID);
        if (authorOptional.isPresent())
            authorOptional.get().setName(author.getName());
        else throw new IllegalStateException("Author with " + authorID + " does not exist");
        return authorRepository.save(authorOptional.get());
    }


    public Author getAuthor(long authorID) {
        Optional<Author> authorOptional = authorRepository.getAuthorEntityById(authorID);
        if (authorOptional.isPresent()) {
            return authorOptional.get();
            // return new ResponseEntity<>("Product found successfully", HttpStatus.OK);
        } else {
            throw new AuthorNotFoundException();
        }
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();

    }

    public List<Book> getBooksFromAuthor(Long authorID) {
        Optional<Author> optionalAuthor = authorRepository.getAuthorEntityById(authorID);
        if (optionalAuthor.isPresent()) {
            List<Book> bookList = optionalAuthor.get().getBooks();
            return bookList;
        } else throw new IllegalStateException("bad author");
    }

    public void deleteAuthors() {
        authorRepository.deleteAll();
    }
}
