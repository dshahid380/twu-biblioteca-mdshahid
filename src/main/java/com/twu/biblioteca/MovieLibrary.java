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
            console.display(movie.getMoviesDetails());
    }

    public void checkOut(Movie movie) {
        if (movies.contains(movie)) {
            checkOutMovies.add(movie);
            movies.remove(movie);
            console.display("Thank you! Enjoy the Movie");
            return;
        }
        console.display("Sorry, that movie is not available");
    }

}
