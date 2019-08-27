package com.example.book.repository;

import com.example.book.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, java.lang.Long> {

    Optional<Author> getAuthorEntityById(Long idBook);
}
