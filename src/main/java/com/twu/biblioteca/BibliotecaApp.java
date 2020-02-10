package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {
    private String welcomeMessage;
    private List<Book> bookList = List.of(new Book("Book1","Author1","1997"),
            new Book("Book2","Author2","1998"));
    private List<String> menuList = List.of("List of Books", "Quit");
    private List<Book> checkoutList = new ArrayList<>();

    private int input;

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }

    public void printWelcomeMessage() {
        welcomeMessage = "Welcome to Biblioteca. You one-stop-shop for great book titles in Bangalore!";
        System.out.println(welcomeMessage);
    }

    public void start(){
        Library library = new Library(this.bookList,this.checkoutList);
        Menu menu = new Menu(library,this.menuList);
        Scanner scanner = new Scanner(System.in);
        this.printWelcomeMessage();
        do {
            menu.show();
            this.input = scanner.nextInt();
            menu.performOperation(this.input);
        } while (this.input != 2);
    }

}
