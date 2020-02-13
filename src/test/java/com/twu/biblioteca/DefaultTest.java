package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DefaultTest {
    @Test
    void testShouldReturnListOfDefaultBooks() {
        Default aDefault = new Default();
        List<Book> books = new ArrayList<>();
        books.add(new Book("Book1", "Author1", "1997"));
        books.add(new Book("Book2", "Author2", "1998"));
        assertEquals(books.get(0), aDefault.getDefaultBooks().get(0));
        assertEquals(books.get(1), aDefault.getDefaultBooks().get(1));
    }

    @Test
    void testShouldReturnListOfDefaultMovies() {
        Default aDefault = new Default();
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Movie1", "2000", "Director1", "10"));
        movies.add(new Movie("Movie2", "2001", "Director2", "9"));
        assertEquals(movies.get(0), aDefault.getDefaultMovies().get(0));
        assertEquals(movies.get(1), aDefault.getDefaultMovies().get(1));
    }

    @Test
    void testShouldReturnListOfMenus() {
        Default aDefault = new Default();
        List<String> menuList = List.of("List of Books", "Check Out Book", "Return a book", "Quit");
        assertEquals(menuList.get(0), aDefault.getMenu().get(0));
        assertEquals(menuList.get(1), aDefault.getMenu().get(1));
    }
}