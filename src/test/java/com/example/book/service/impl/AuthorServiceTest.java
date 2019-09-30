package com.example.book.service.impl;

import com.example.book.exceptions.AuthorAlreadyExistException;
import com.example.book.exceptions.AuthorNotFoundException;
import com.example.book.model.Author;
import com.example.book.model.dto.AuthorDTO;
import com.example.book.repository.AuthorRepository;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AuthorServiceTest {


    static AuthorRepository authorRepository;

    @InjectMocks
    static AuthorService service;


    @BeforeClass
    public static void setUp() {
        authorRepository = mock(AuthorRepository.class);
    }

    @Test
    public void getAllAuthorsTest() {
        Author author1 = new Author("benjamin");
        Author author2 = new Author("amir");
        Author author3 = new Author("kenan");
        when(authorRepository.findAll()).thenReturn(Arrays.asList(author1, author2, author3));

        ArrayList<AuthorDTO> allAuthors = service.getAllAuthors();
        assertEquals(3, allAuthors.size());
        assertEquals("benjamin", allAuthors.get(0).getName());
    }

    @Test
//    @Test(expected = AuthorAlreadyExistException.class)
    public void saveAuthorTest() {
        Author author1 = new Author("benjamin");
        when(authorRepository.save(author1)).thenReturn(author1);
        service.save(author1);
        verify(authorRepository, times(1)).save(author1);

    }

    @Test
    public void findAuthorByIDTest() {


    }

    @Test(expected = AuthorNotFoundException.class)
    public void deleteAuthorTest() {
        Author author1 = new Author("benjamin");
        when(authorRepository.save(author1)).thenReturn(author1);
        AuthorDTO author = service.save(author1);
        verify(authorRepository, times(1)).save(author1);
        service.deleteAuthor(author.getId());
        when(authorRepository.save(author1)).thenThrow(new AuthorNotFoundException());
        service.save(author1);
        verify(authorRepository, times(1)).save(author1);
    }


}