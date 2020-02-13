package com.twu.biblioteca;

import java.io.IOException;
import java.util.*;

public class BibliotecaApp {
    Default aDefault = new Default();
    private List<Book> books = aDefault.getDefaultBooks();
    private List<Movie> movies = aDefault.getDefaultMovies();
    private List<String> menuList = aDefault.getMenu();
    private Console console;

    public BibliotecaApp(Console console) {
        this.console = console;

    }

    public static void main(String[] args) throws IOException {
        new BibliotecaApp(new Console()).start();
    }

    public void printWelcomeMessage() {
        console.display("Welcome to Biblioteca. You one-stop-shop for great book titles in Bangalore!");
    }

    public void start() throws IOException {
        Menu menu = new Menu(menuList, console);
        BookLibrary bookLibrary = new BookLibrary(books, console);
        MovieLibrary movieLibrary = new MovieLibrary(movies, console);
        HashMap<Integer, MenuItem> menuItems = aDefault.getMenuItems(bookLibrary, movieLibrary, console);
        UserInput userInput = new UserInput(menuItems, console);

        printWelcomeMessage();
        do {
            menu.show();
            userInput.readInput();
        } while (userInput.isExit());
    }

}

