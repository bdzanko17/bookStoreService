package com.example.book.repository;

import com.example.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {

    Optional<Book> getBookEntityById(Long idBook);
    Optional<Book> getBookEntityByTitle(String title);

}
