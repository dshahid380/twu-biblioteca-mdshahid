package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {
    private List<Book> bookList = getBookList();
    private List<String> menuList = getMenuList();

    public static void main(String[] args) {
        new BibliotecaApp().start();
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to Biblioteca. You one-stop-shop for great book titles in Bangalore!");
    }

    public void start() {
        Library library = new Library(this.bookList);
        Menu menu = new Menu(this.menuList);
        UserInput userInput = new UserInput(library);

        this.printWelcomeMessage();
        do {
            menu.show();
            userInput.readInput();
        } while (true);
    }

    private List<Book> getBookList() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Book1", "Author1", "1997"));
        bookList.add(new Book("Book2", "Author2", "1998"));
        return bookList;
    }

    private List<String> getMenuList() {
        return List.of("List of Books", "Check Out Book", "Quit");
    }

}
