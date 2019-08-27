package com.example.book.model.EntityInput;

public class AuthorEntityInput {
    private String name;

    public AuthorEntityInput(String name) {
        this.name = name;
    }

    public AuthorEntityInput() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
