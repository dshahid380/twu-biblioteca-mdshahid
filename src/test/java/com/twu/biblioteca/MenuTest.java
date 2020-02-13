package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

class MenuTest {
    Menu menu;
    Console console;

    @BeforeEach
    public void setUp() {
        console = mock(Console.class);
        List<String> menuList = List.of("List of Books", "Quit");
        menu = new Menu(menuList, console);
    }

    @Test
    void testShouldPrintListOfMenus() {
        menu.show();
        verify(console).display("List of Books");
        verify(console).display("Quit");
    }

}