package com.example.book.repository;

import com.example.book.model.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PageRepository extends JpaRepository<Page,Long> {
    Optional<Page> getPageEntityById(Long id);
}
