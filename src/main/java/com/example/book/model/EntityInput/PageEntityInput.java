package com.example.book.model.EntityInput;

public class PageEntityInput {
    private Long ordinalNumber;
    private String content;
    private Long BookID;

    public PageEntityInput(Long ordinalNumber, String content, Long bookID) {
        this.ordinalNumber = ordinalNumber;
        this.content = content;
        BookID = bookID;
    }

    public PageEntityInput() {
    }

    public Long getOrdinalNumber() {
        return ordinalNumber;
    }

    public void setOrdinalNumber(Long ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getBookID() {
        return BookID;
    }

    public void setBookID(Long bookID) {
        BookID = bookID;
    }
}
