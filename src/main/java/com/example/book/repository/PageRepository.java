package com.example.book.repository;

import com.example.book.model.Pagee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PageRepository extends JpaRepository<Pagee,Long> {
    Optional<Pagee> getPageEntityById(Long id);
}
