package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ConsoleTest {
    @Test
    void testShouldReturnAInputString() throws IOException {
        Console console = new Console();
        System.setIn(new ByteArrayInputStream("Book".getBytes()));
        String inputString = console.read();
        assertEquals("Book",inputString);
    }

    @Test
    void testShouldPrintAMessageOnScreen() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        Console console = new Console();
        String message = "Hello";
        console.display("Hello");
        verify(printStream).println("Hello");
    }
    @Test
    void testShouldReturnABook() throws IOException {
        Console console = new Console();
        System.setIn(new ByteArrayInputStream("Book".getBytes()));
        System.setIn(new ByteArrayInputStream("Author".getBytes()));
        System.setIn(new ByteArrayInputStream("2001".getBytes()));
        Book book = console.readBook();
        assertEquals(new Book("Book","Author","2001"),book);
    }
}