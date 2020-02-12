package com.twu.biblioteca;

import java.io.IOException;

public class UserInput {
    private boolean status = true;
    private BookLibrary bookLibrary;
    private Console console;

    public UserInput(BookLibrary bookLibrary, Console console) {
        this.bookLibrary = bookLibrary;
        this.console = console;
    }

    public void readInput() throws IOException {
        //Magic numbers
        final int DISPLAY_BOOK = 1;
        final int CHECKOUT_BOOK = 2;
        final int RETURN_BOOK = 3;
        //final int MOVIES_LIST = 4;
        final int QUIT = 4;

        int userInput = console.readInteger();

        switch (userInput) {
            case DISPLAY_BOOK:
                bookLibrary.displayAllBooks();
                break;
            case CHECKOUT_BOOK:
                Book book = console.readBook();
                bookLibrary.checkOut(book);
                break;
            case RETURN_BOOK:
                bookLibrary.returnBook(console.readBook());
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
