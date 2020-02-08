package com.twu.biblioteca;

public class Book {
    private final String bookName;
    private final String authorName;
    private final String year;
    public Book(String bookName, String authorName, String year) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.year = year;
    }

    public String getBookName(){
        return this.bookName;
    }
    public String getAuthorName(){
        return this.authorName;
    }
    public String getYear(){
        return this.year;
    }
}
