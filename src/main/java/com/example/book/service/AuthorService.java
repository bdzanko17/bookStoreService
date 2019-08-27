package com.example.book.service;

import com.example.book.model.Author;
import com.example.book.model.Book;
import com.example.book.repository.AuthorRepository;
import com.example.book.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author save(Author author) {
        Optional<Author> authorOptional = authorRepository.getAuthorEntityById(author.getId());
        if(authorOptional.isPresent()){
            throw new IllegalStateException("bad");
        }
        return authorRepository.save(author);

    }




//    public Author addBookToAuthorr(Long idAuthor, Long idBook) { //Adding author books id
//
//        Optional<Book> bookOptional = bookRepository.getBookEntityById(idBook);
//        Optional<Author> authorOptional = authorRepository.getAuthorEntityById(idAuthor);
//
//       if (bookOptional.isPresent() && authorOptional.isPresent()) {
//           System.out.println(bookOptional.get().getId());
//            return authorOptional.get();
//        } else {
//            throw new IllegalArgumentException("bad");
//     }
//
//    }

}
