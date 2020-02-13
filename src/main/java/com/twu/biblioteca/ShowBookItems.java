package com.twu.biblioteca;

public class ShowBookItems implements MenuItem {
    private BookLibrary bookLibrary;

    public ShowBookItems(BookLibrary bookLibrary) {
        this.bookLibrary = bookLibrary;
    }

    @Override
    public void performOperation() {
        bookLibrary.displayAllBooks();
    }
}
