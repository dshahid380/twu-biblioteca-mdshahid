package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class LibraryTest {
    Library library;
    PrintStream printStream;

    @BeforeEach
    void setUp() {
        printStream = mock(PrintStream.class);
        System.setOut(printStream);
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Book1", "Author1", "1997"));
        bookList.add(new Book("Book2", "Author2", "1998"));
        bookList.add(new Book("Book3", "Author3", "1999"));
        List<Book> checkoutList = new ArrayList<>();
        library = new Library(bookList, checkoutList);
    }

    @Test
    void testShouldDisplayBooksWithItsAuthorAndYear() {
        library.displayAllBooks();
        verify(printStream).print("Book1");
        verify(printStream).print("Author1");
        verify(printStream).print("1997");
        verify(printStream).print("Book2");
        verify(printStream).print("Author2");
        verify(printStream).print("1998");
    }

    @Test
    void testShouldCheckOutBookFromLibrary() {
        Book book = new Book("Book2", "Author2", "1998");

        library.checkOut(book);
        library.displayAllBooks();

        verify(printStream, times(1)).print("Book1");
        verify(printStream, times(0)).print("Book2");
    }

}