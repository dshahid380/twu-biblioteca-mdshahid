package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {
    private List<Book> books;
    private List<Book> checkOutBooks;

    private Console console;

    public BookLibrary(List<Book> books, Console console) {
        this.books = books;
        this.console = console;
        this.checkOutBooks = new ArrayList<>();
    }

    public void displayAllBooks() {
        for (Book book : books) console.display(book.getItemDetails());
    }

    public void checkOut(Book book) {
        if (books.contains(book)) {
            checkOutBooks.add(book);
            books.remove(book);
            console.display("Thank you! Enjoy the Book");
            return;
        }
        console.display("Sorry, that book is not available");
    }

    public void returnBook(Book book) {
        if (books.contains(book)) {
            checkOutBooks.remove(book);
            books.add(book);
            console.display("Thank you for returning the book!");
            return;
        }
        console.display("That is not a valid book to return");
    }
}
