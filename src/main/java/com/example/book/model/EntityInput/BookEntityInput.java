package com.example.book.model.EntityInput;

import java.util.List;

public class BookEntityInput {
    private String title;
    private String genre;
    private List<Long> authors;

    public BookEntityInput( String title, String genre, List<Long> authors) {
        this.title = title;
        this.genre = genre;
        this.authors = authors;
    }

    public BookEntityInput() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Long> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Long> authors) {
        this.authors = authors;
    }
}
