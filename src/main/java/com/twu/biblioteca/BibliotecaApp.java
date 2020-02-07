package com.twu.biblioteca;

import java.util.List;

import static java.util.Arrays.asList;

public class BibliotecaApp {
    private String welcomeMessage = "Welcome to Biblioteca. You one-stop-shop for great book titles in Bangalore!";
    private List<String> bookList = asList("1. Mathematics", "2. Physics", "3. Astrophysics");

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
        bibliotecaApp.displayAllBooks();
    }

    public void start() {
        System.out.println(welcomeMessage);
    }

    public void displayAllBooks() {
        for (String book : bookList) System.out.println(book);

    }

}
