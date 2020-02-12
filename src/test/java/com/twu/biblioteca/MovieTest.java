package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class MovieTest {
    @Test
    void testShouldReturnMovieDetails() {
        Console console = mock(Console.class);
        Movie movie = new Movie("Movie1", "2020", "Director1", "10");
        String expected = "Movie1 2020 Director1 10";
        Assertions.assertEquals(expected, movie.getMoviesDetails());
    }
}