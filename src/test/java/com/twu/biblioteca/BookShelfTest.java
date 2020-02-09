package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BookShelfTest {
    @Test
    void testShouldDisplayBooksWithItsAuthorAndYear() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        BookShelf bookShelf = new BookShelf();
        bookShelf.displayAllBooks();
        verify(printStream).print("Book1");
        verify(printStream).print("Author1");
        verify(printStream).print("1997");
        verify(printStream).print("Book2");
        verify(printStream).print("Author2");
        verify(printStream).print("1998");
    }
}