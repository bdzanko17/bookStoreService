package com.example.book.service;

import com.example.book.model.Author;
import com.example.book.model.Book;
import com.example.book.repository.AuthorRepository;
import com.example.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;



    @Autowired
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

    public void deleteAuthor(Long id) {
        authorRepository.delete(authorRepository.getOne(id));
    }

    public Author changeAuthorName(Author author, long authorID) {
        Optional<Author> authorOptional =  authorRepository.getAuthorEntityById(authorID);
        if(authorOptional.isPresent())
        authorOptional.get().setName(author.getName());
        else throw new IllegalStateException("Author with " +authorID+" does not exist");
        return authorRepository.save(authorOptional.get());
    }




}
