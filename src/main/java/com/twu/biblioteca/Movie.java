package com.twu.biblioteca;

import java.util.Objects;

public class Movie {
    private String movieName;
    private String year;
    private String director;
    private String rating;
    private Console console;

    public Movie(String movieName, String year, String director, String rating, Console console) {
        this.movieName = movieName;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.console = console;
    }

    public void showMoviesDetails() {
        console.display(String.format("%s %s %s %s", movieName, year, director, rating));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(movieName, movie.movieName) &&
                Objects.equals(year, movie.year) &&
                Objects.equals(director, movie.director) &&
                Objects.equals(rating, movie.rating) &&
                Objects.equals(console, movie.console);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieName, year, director, rating, console);
    }
}
