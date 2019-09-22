package com.example.book.repository;

import com.example.book.exceptions.BookNotFoundException;
import com.example.book.model.Author;
import com.example.book.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@DataJpaTest
@RunWith(SpringRunner.class)
public class AuthorRepositoryTest {

    @Resource
    private AuthorRepository authorRepository;
    @Resource
    private BookRepository bookRepository;

    @Test
    public void addAuthor() {
        Author author = new Author("Benjamin");
        authorRepository.save(author);
        List<Author> authors = authorRepository.findAll();
        assertEquals(1, authors.size());
    }

    @Test
    public void deleteAuthor() {
        Author author = new Author("Benjamin");
        authorRepository.save(author);
        authorRepository.delete(author);
        List<Author> authors = authorRepository.findAll();
        assertEquals(0, authors.size());
    }

    @Test
    public void getAuthor() {
        Author author = new Author("Benjamin");
        authorRepository.save(author);
        Optional<Author> authorOptional = authorRepository.getAuthorEntityById(author.getId());
        assertEquals(author.getName(), authorOptional.get().getName());
    }

}