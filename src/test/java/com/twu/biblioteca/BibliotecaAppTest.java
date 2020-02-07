package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BibliotecaAppTest {

    @Test
    public void testShouldCheckThatAWelcomeMessageIsPrinting() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        BibliotecaApp.main(new String[]{});
        verify(printStream).println("Welcome to Biblioteca. You one-stop-shop for great book titles in Bangalore!");
    }
}