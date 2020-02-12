package com.twu.biblioteca;
import java.io.IOException;
import java.util.*;

public class BibliotecaApp {
    private List<Book> books = getDefaultBooks();
    private List<String> menuList = getMenu();
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
        Library library = new Library(books, console);
        UserInput userInput = new UserInput(library, console);

        printWelcomeMessage();
        do {
            menu.show();
            userInput.readInput();
        } while (userInput.isExit());
    }

    private List<Book> getDefaultBooks() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Book1", "Author1", "1997"));
        bookList.add(new Book("Book2", "Author2", "1998"));
        return bookList;
    }

    private List<String> getMenu() {
        return List.of("List of Books", "Check Out Book", "Return a book", "Quit");
    }

}

