package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> bookList;
    private List<Book> checkOutList;

    public Library(List<Book> bookList) {
        this.bookList = bookList;
        checkOutList = new ArrayList<>();
    }

    public void displayAllBooks() {
        for (Book book : bookList) {
            System.out.print(book.getBookName());
            System.out.print(" ");
            System.out.print(book.getAuthorName());
            System.out.print(" ");
            System.out.print(book.getYear());
            System.out.println();
        }
    }

    public void checkOut(Book book) {
        for (int i = 0; i < this.bookList.size(); i++) {
            if (bookList.get(i).equals(book)) {
                this.checkOutList.add(book);
                this.bookList.remove(i);
                return;
            }
        }
        System.out.println("Sorry, that book is not available");
    }

}
