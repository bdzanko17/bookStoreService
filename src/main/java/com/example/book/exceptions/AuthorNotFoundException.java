package com.example.book.exceptions;

public class AuthorNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    Long id;

    public AuthorNotFoundException(Long id) {
        this.id = id;
    }

    public AuthorNotFoundException(String message, Long id) {
        super(message);
        this.id = id;
    }

    public AuthorNotFoundException(String message, Throwable cause, Long id) {
        super(message, cause);
        this.id = id;
    }

    public AuthorNotFoundException(Throwable cause, Long id) {
        super(cause);
        this.id = id;
    }

    public AuthorNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Long id) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
