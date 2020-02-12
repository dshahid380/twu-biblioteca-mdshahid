package com.twu.biblioteca;

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

    public void showMoviesDetails(){
        console.display(String.format("%s %s %s %s", movieName, year, director, rating));
    }
}
