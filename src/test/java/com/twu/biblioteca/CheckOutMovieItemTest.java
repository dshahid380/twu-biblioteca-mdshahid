package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class CheckOutMovieItemTest {
    Console console;
    MovieLibrary movieLibrary;
    CheckOutMovieItem checkOutMovieItem;

    @BeforeEach
    void setUp() {
        console = mock(Console.class);
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Movie1", "2000", "Director1", "10"));
        movieList.add(new Movie("Movie2", "2001", "Director2", "9"));
        movieList.add(new Movie("Movie3", "2002", "Director3", "8"));
        movieLibrary = new MovieLibrary(movieList, console);
        checkOutMovieItem = new CheckOutMovieItem(movieLibrary, console);
    }

    @Test
    void testShouldCheckOutABookFromBookList() throws IOException {
        when(console.readMovie()).thenReturn(new Movie("Movie1", "2000", "Director1", "10"));
        checkOutMovieItem.performOperation();
        movieLibrary.displayAllMovies();
        verify(console).display("Movie2 2001 Director2 9");
        verify(console).display("Movie3 2002 Director3 8");
    }
}