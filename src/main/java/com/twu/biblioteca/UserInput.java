package com.twu.biblioteca;

import java.io.IOException;

public class UserInput {
    private boolean status = true;
    private BookLibrary bookLibrary;
    private MovieLibrary movieLibrary;
    private Console console;

    public UserInput(BookLibrary bookLibrary, MovieLibrary movieLibrary, Console console) {
        this.bookLibrary = bookLibrary;
        this.console = console;
        this.movieLibrary = movieLibrary;
    }

    public void readInput() throws IOException {
        //Magic numbers
        final int DISPLAY_BOOK = 1;
        final int CHECKOUT_BOOK = 2;
        final int RETURN_BOOK = 3;
        final int MOVIES_LIST = 4;
        final int CHECKOUT_MOVIE = 5;
        final int QUIT = 6;

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
            case MOVIES_LIST:
                movieLibrary.displayAllMovies();
            case CHECKOUT_MOVIE:
                movieLibrary.checkOut(console.readMovie());
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
