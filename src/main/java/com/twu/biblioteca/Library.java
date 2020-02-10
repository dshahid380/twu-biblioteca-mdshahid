package com.twu.biblioteca;

import java.util.List;

public class Library {
    private List<Book> bookList;
    private List<Book> checkOutList;

    public Library(List<Book> bookList, List<Book> checkoutList) {
        this.bookList = bookList;
        this.checkOutList = checkoutList;
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

    public void checkOut(Book book) {
        this.checkOutList.add(book);
        this.bookList.remove(0);
    }

}
