package com.example.book.service;

import com.example.book.model.Author;
import com.example.book.model.Book;
import com.example.book.model.EntityInput.BookEntityInput;
import com.example.book.model.Pagee;
import com.example.book.repository.AuthorRepository;
import com.example.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    public Book getBookByID(Long id) {
        return bookRepository.getOne(id);
    }

    public Book saveBook(BookEntityInput book) {
        Optional<Book> bookOptional = bookRepository.getBookEntityByTitle(book.getTitle());
        if (bookOptional.isPresent()) throw new IllegalStateException("Book already exist");
        List<Long> authorID = book.getAuthors();
        List<Author> authors = new ArrayList<>();
        for (int i = 0; i < authorID.size(); i++) {
            Optional<Author> authorOptional = authorRepository.getAuthorEntityById(authorID.get(i));
            if (authorOptional.isPresent())
                authors.add(authorOptional.get());
            else throw new IllegalStateException("There is no authors for this book");
        }
        Book newBook = new Book(book.getTitle(), book.getGenre());
        newBook.setAuthors(authors);
        return bookRepository.save(newBook);


    }

    public List<Book> getBookList() {
        return bookRepository.findAll();
    }


    public Book updateBook(BookEntityInput bookEntityInput, Long bookID) {
        Optional<Book> bookOptional = bookRepository.getBookEntityById(bookID);
        List<Long> authors = bookEntityInput.getAuthors();
        List<Long> pages= bookEntityInput.getPages();
        if(bookOptional.isPresent()){
        }
        return null;
    }
}
