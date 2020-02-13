package com.twu.biblioteca;

import java.io.IOException;

public class ReturnBookItem implements MenuItem {
    private BookLibrary bookLibrary;
    private Console console;

    public ReturnBookItem(BookLibrary bookLibrary, Console console) {
        this.bookLibrary = bookLibrary;
        this.console = console;
    }

    @Override
    public void performOperation() throws IOException {
        bookLibrary.returnBook(console.readBook());
    }
}
