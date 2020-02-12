package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class MovieLibraryTest {
    MovieLibrary movieLibrary;
    Console console;

    @BeforeEach
    void setUp() {
        console = mock(Console.class);
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Movie1", "2001", "Director1", "10"));
        movieList.add(new Movie("Movie2", "2002", "Director2", "9"));
        movieLibrary = new MovieLibrary(movieList, console);
    }

    @Test
    void testShouldDisplayMoviesWithItsAuthorAndYear() {
        movieLibrary.displayAllMovies();
        verify(console).display("Movie1 2001 Director1 10");
        verify(console).display("Movie2 2002 Director2 9");
    }

    @Test
    void testShouldCheckOutMovieFromLibrary() {
        Movie movie = new Movie("Movie1", "2001", "Director1", "10");

        movieLibrary.checkOut(movie);
        movieLibrary.displayAllMovies();

        verify(console, times(0)).display("Movie1 2001 Director1 10");
        verify(console, times(1)).display("Movie2 2002 Director2 9");
    }

}