package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BookShelfTest {
    @Test
    void testShouldDisplayBooksWithItsAuthorAndYear() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);

        List<Book> bookList = List.of(new Book("Book1", "Author1", "1997"),
                new Book("Book2", "Author2", "1998"));
        BookShelf bookShelf = new BookShelf(bookList);
        bookShelf.displayAllBooks();
        verify(printStream).print("Book1");
        verify(printStream).print("Author1");
        verify(printStream).print("1997");
        verify(printStream).print("Book2");
        verify(printStream).print("Author2");
        verify(printStream).print("1998");
    }
}