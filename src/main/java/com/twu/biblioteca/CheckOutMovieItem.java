package com.twu.biblioteca;

import java.io.IOException;

public class CheckOutMovieItem implements MenuItem {
    private MovieLibrary movieLibrary;
    private Console console;

    public CheckOutMovieItem(MovieLibrary movieLibrary, Console console) {
        this.movieLibrary = movieLibrary;
        this.console = console;
    }

    @Override
    public void performOperation() throws IOException {
        movieLibrary.checkOut(console.readMovie());
    }
}
