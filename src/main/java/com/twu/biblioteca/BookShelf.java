package com.twu.biblioteca;

import java.util.List;

public class BookShelf {
    private List<Book> bookList;

    public BookShelf(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void displayAllBooks() {
        for (Book book : bookList) {
            System.out.print(book.getBookName());
            System.out.print(" ");
            System.out.print(book.getAuthorName());
            System.out.print(" ");
            System.out.print(book.getYear());
            System.out.println("");
        }
    }

}
