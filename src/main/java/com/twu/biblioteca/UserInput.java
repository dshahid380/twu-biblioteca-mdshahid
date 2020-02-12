package com.twu.biblioteca;

import java.io.IOException;

public class UserInput {
    private boolean status = true;
    private Library library;
    private Console console;

    public UserInput(Library library, Console console) {
        this.library = library;
        this.console = console;
    }

    public void readInput() throws IOException {
        //Magic numbers
        final int DISPLAY_BOOK = 1;
        final int CHECKOUT_BOOK = 2;
        final int RETURN_BOOK = 3;
        final int QUIT = 4;

        int userInput = console.readInteger();

        switch (userInput) {
            case DISPLAY_BOOK:
                library.displayAllBooks();
                break;
            case CHECKOUT_BOOK:
                Book book = console.readBook();
                library.checkOut(book);
                break;
            case RETURN_BOOK:
                library.returnBook(console.readBook());
            case QUIT:
                status = false;
                console.display("Thank you!");
                break;
            default:
                console.display("Please select a valid option!");
        }
    }

    public boolean isExit() {
        return status;
    }
}
