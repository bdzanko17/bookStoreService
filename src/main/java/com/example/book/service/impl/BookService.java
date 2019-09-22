package com.example.book.service.impl;

import com.example.book.exceptions.AuthorNotFoundException;
import com.example.book.exceptions.BookAlreadyExistException;
import com.example.book.exceptions.BookNotFoundException;
import com.example.book.model.Author;
import com.example.book.model.Book;
import com.example.book.model.EntityInput.BookEntityInput;
import com.example.book.model.Page;
import com.example.book.repository.AuthorRepository;
import com.example.book.repository.BookRepository;
import com.example.book.service.IBookService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    public Book getBookByID(Long id) {
        Optional<Book> bookOptional = bookRepository.getBookEntityById(id);
        return bookOptional.get();

    }

    public Book saveBook(BookEntityInput book) {
        Optional<Book> bookOptional = bookRepository.getBookEntityByTitle(book.getTitle());
        if (bookOptional.isPresent()) throw new BookAlreadyExistException();
        List<Long> authorID = book.getAuthors();
        List<Author> authors = new ArrayList<>();
        Boolean addedAuthors = false;
        for (int i = 0; i < authorID.size(); i++) {
            Optional<Author> authorOptional = authorRepository.getAuthorEntityById(authorID.get(i));
            if (authorOptional.isPresent()) {
                authors.add(authorOptional.get());
                addedAuthors = true;
            } else continue;
        }
        if (!addedAuthors) throw new AuthorNotFoundException();
        Book newBook = new Book(book.getTitle(), book.getGenre());
        newBook.setAuthors(authors);
        return bookRepository.save(newBook);


    }

    @Override
    public Book saveBook(Book book) {//for test only
        Optional<Book> bookOptional = bookRepository.getBookEntityByTitle(book.getTitle());
        if (bookOptional.isPresent()) throw new BookAlreadyExistException();
        return bookRepository.save(book);
    }

    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    @Override
    public List<Page> getPageList(String id) {
        Optional<Book> bookOptional = bookRepository.getBookEntityById(Long.parseLong(id));
        return bookOptional.get().getPages();
    }

    @Override
    public List<Author> getAuthorList(String id) {
        Optional<Book> bookOptional = bookRepository.getBookEntityById(Long.parseLong(id));
        return bookOptional.get().getAuthors();
    }

    @Override
    public void deleteBook(String id) {
        Optional<Book> bookOptional = bookRepository.getBookEntityById(Long.valueOf(id));
        if (bookOptional.isPresent())
            bookRepository.delete(bookRepository.getOne(Long.parseLong(id)));
        else throw new BookNotFoundException();
    }


}
