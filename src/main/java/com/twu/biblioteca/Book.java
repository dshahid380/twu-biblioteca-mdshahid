package com.twu.biblioteca;

import java.util.Objects;

public class Book {
    private final String bookName;
    private final String authorName;
    private final String year;

    public Book(String bookName, String authorName, String year) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.year = year;
    }

    public String getBookDetail() {
        return (bookName + " " + authorName + " " + year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookName, book.bookName) &&
                Objects.equals(authorName, book.authorName) &&
                Objects.equals(year, book.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, authorName, year);
    }
}
