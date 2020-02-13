package com.twu.biblioteca;

import java.io.IOException;

public class CheckOutBookItem implements MenuItem {
    private BookLibrary bookLibrary;
    private Console console;

    public CheckOutBookItem(BookLibrary bookLibrary, Console console) {
        this.bookLibrary = bookLibrary;
        this.console = console;
    }

    @Override
    public void performOperation() throws IOException {
        Book book = console.readBook();
        bookLibrary.checkOut(book);
    }
}
