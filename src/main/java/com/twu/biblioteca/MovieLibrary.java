package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class MovieLibrary {
    private List<Movie> movies;
    private List<Movie> checkOutMovies;

    private Console console;

    public MovieLibrary(List<Movie> movies, Console console) {
        this.movies = movies;
        this.console = console;
        this.checkOutMovies = new ArrayList<>();
    }

    public void displayAllMovies() {
        for (Movie movie : movies)
            movie.showMoviesDetails();
    }

}
