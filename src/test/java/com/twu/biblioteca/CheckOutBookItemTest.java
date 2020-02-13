package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class CheckOutBookItemTest {
    Console console;
    BookLibrary bookLibrary;
    CheckOutBookItem checkOutBookItem;

    @BeforeEach
    void setUp() {
        console = mock(Console.class);
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Book1", "Author1", "1997"));
        bookList.add(new Book("Book2", "Author2", "1998"));
        bookList.add(new Book("Book3", "Author3", "1999"));
        bookLibrary = new BookLibrary(bookList, console);
        checkOutBookItem = new CheckOutBookItem(bookLibrary, console);
    }

    @Test
    void testShouldCheckOutABookFromBookList() throws IOException {
        when(console.readBook()).thenReturn(new Book("Book1", "Author1", "1997"));
        checkOutBookItem.performOperation();
        bookLibrary.displayAllBooks();
        verify(console).display("Book2 Author2 1998");
        verify(console).display("Book3 Author3 1999");
    }
}