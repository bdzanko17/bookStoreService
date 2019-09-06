package com.example.book.exceptions;

public class AuthorNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private Long id;

    public AuthorNotFoundException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
