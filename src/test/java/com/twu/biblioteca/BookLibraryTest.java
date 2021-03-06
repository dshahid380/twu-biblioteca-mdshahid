package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class BookLibraryTest {
    BookLibrary bookLibrary;
    Console console;

    @BeforeEach
    void setUp() {
        console = mock(Console.class);
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Book1", "Author1", "1997"));
        bookList.add(new Book("Book2", "Author2", "1998"));
        bookList.add(new Book("Book3", "Author3", "1999"));
        bookLibrary = new BookLibrary(bookList, console);
    }

    @Test
    void testShouldDisplayBooksWithItsAuthorAndYear() {
        bookLibrary.displayAllBooks();
        verify(console).display("Book1 Author1 1997");
        verify(console).display("Book2 Author2 1998");
    }

    @Test
    void testShouldCheckOutBookFromLibrary() {
        Book book = new Book("Book2", "Author2", "1998");

        bookLibrary.checkOut(book);
        bookLibrary.displayAllBooks();

        verify(console, times(1)).display("Book1 Author1 1997");
        verify(console, times(0)).display("Book2 Author2 1998");
    }

}