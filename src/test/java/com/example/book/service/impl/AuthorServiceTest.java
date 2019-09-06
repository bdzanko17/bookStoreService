package com.example.book.service.impl;

import com.example.book.model.Author;
import com.example.book.repository.AuthorRepository;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AuthorServiceTest {
    @InjectMocks
    static AuthorService service;


    static AuthorRepository authorRepository;

    @BeforeClass
    public static void setUp() {
        authorRepository = mock(AuthorRepository.class);
        Author author = new Author("benjamin");
        Author author2 = new Author("benjaminn");
        Author author3 = new Author("benjaminnn");

        when(authorRepository.findAll()).thenReturn(Arrays.asList(author));
        when(authorRepository.save(author)).thenReturn(author);
     //   when(authorRepository.getAuthorEntityByName("benjamin")).thenReturn(Optional.of(author));

        when(authorRepository.save(author2)).thenReturn(author);

    }

    @Test
    public void getAllAuthorsTest() {
        List<Author> allAuthors = service.getAllAuthors();
        assertEquals(3, allAuthors.size());
        assertEquals("Asim2", allAuthors.get(1).getName());
    }

    @Test
    public void save() {
        Author author = new Author("benjamin");
        assertEquals("benjamin", service.save(author));


    }

    @Test
    public void findByIdTest() {
        Author author = new Author(1L, "benjamin");
        authorRepository.save(author);

        assertEquals("Asim1", service.getAuthor(1L).toString());


    }

}