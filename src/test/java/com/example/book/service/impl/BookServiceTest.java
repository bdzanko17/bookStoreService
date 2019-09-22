package com.example.book.service.impl;

import com.example.book.exceptions.AuthorNotFoundException;
import com.example.book.exceptions.BookNotFoundException;
import com.example.book.model.Author;
import com.example.book.model.Book;
import com.example.book.model.EntityInput.BookEntityInput;
import com.example.book.repository.AuthorRepository;
import com.example.book.repository.BookRepository;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import sun.rmi.runtime.Log;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BookServiceTest {
    static BookRepository bookRepository;
    static AuthorRepository authorRepository;

    @InjectMocks
    static BookService bookService;
    @InjectMocks
    static AuthorService authorService;

    //    public static BookEntityInput bookEntityInput = new BookEntityInput("dozivljaj", "benjamin", Arrays.asList(1l));


    @BeforeClass
    public static void setUp() {
        bookRepository = mock(BookRepository.class);
        authorRepository = mock(AuthorRepository.class);
    }


    @Test
    public void saveTest() {
        Author author1 = new Author(1L, "amir");
        when(authorRepository.save(author1)).thenReturn(author1);
        Author author = authorService.save(author1);
        assertEquals("amir", author.getName());
        Book book = new Book("dozivljaj", "benjamin");
        book.setId(1l);
        book.setAuthors(Arrays.asList(author));
        when(bookRepository.save(book)).thenReturn(book);
        Book book1 = bookRepository.save(book);
        verify(bookRepository, times(1)).save(book);

    }


    @Test
    public void getAllBooksTest() {
        Book book1 = new Book("bilo jednom", "benjamin");
        Book book2 = new Book("Dolasci", "amir");
        Book book3 = new Book("Sve je ok", "haris");
        when(bookRepository.findAll()).thenReturn(Arrays.asList(book1, book2, book3));
        assertEquals(3, bookService.getBookList().size());


    }

    @Test
    public void getBook() {
        Author author1 = new Author(1L, "amir");
        Book book = new Book("dozivljaj", "benjamin");
        book.setId(1l);
        book.setAuthors(Arrays.asList(author1));
        when(bookRepository.save(book)).thenReturn(book);
        Book knjiga = bookService.saveBook(book);
        when(bookRepository.getBookEntityById(knjiga.getId())).thenReturn(Optional.of(book));
        Book book1 = bookService.getBookByID(knjiga.getId());
        assertEquals("dozivljaj", book1.getTitle());
    }

    @Test(expected = BookNotFoundException.class)
    public void deleteBookTest() {
        Author author1 = new Author(1L, "amir");
        when(authorRepository.save(author1)).thenReturn(author1);
        Author author = authorService.save(author1);
        assertEquals("amir", author.getName());
        Book book = new Book("dozivljaj", "benjamin");
        book.setId(1l);
        book.setAuthors(Arrays.asList(author));
        when(bookRepository.save(book)).thenReturn(book);
        Book spasenaKnjiga = bookService.saveBook(book);
        bookService.deleteBook(String.valueOf(spasenaKnjiga.getId()));
        when(bookRepository.getBookEntityByTitle(book.getTitle()).isPresent()).thenThrow(new BookNotFoundException());
        bookRepository.getBookEntityByTitle(book.getTitle());
    }


}