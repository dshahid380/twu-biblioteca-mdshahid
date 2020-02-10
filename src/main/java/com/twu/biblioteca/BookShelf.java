package com.twu.biblioteca;

import java.util.List;

public class BookShelf {
    private List<Book> bookList = List.of(new Book("Book1","Author1","1997"),
            new Book("Book2","Author2","1998"));

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
