package com.twu.biblioteca;

public class ShowMovieItems implements MenuItem {
    private MovieLibrary movieLibrary;

    public ShowMovieItems(MovieLibrary movieLibrary) {
        this.movieLibrary = movieLibrary;
    }

    @Override
    public void performOperation() {
        movieLibrary.displayAllMovies();
    }
}
