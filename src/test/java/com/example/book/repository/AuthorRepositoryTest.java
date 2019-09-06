package com.example.book.repository;

import com.example.book.model.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.swing.*;

import java.util.List;

import static org.junit.Assert.*;

@DataJpaTest
@RunWith(SpringRunner.class)
public class AuthorRepositoryTest {

    @Resource
    private AuthorRepository authorRepository;

    @Test
    public void addAuthor() {
        Author author = new Author("Benjamin");
       authorRepository.save(author);
        List<Author> authors = authorRepository.findAll();
        assertEquals(1,authors.size());
    }
    @Test
    public void deleteAuthor(){
        Author author = new Author("Benjamin");
        authorRepository.save(author);
        authorRepository.delete(author);
        List<Author>authors = authorRepository.findAll();
        assertEquals(0,authors.size());
    }
}