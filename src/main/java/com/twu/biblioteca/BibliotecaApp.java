package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {
    private String welcomeMessage;

    private int input;

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        bibliotecaApp.start();
        do {
            menu.show();
            bibliotecaApp.input = scanner.nextInt();
            menu.performOperation(bibliotecaApp.input);
        } while (bibliotecaApp.input != 4);
    }

    public void start() {
        welcomeMessage = "Welcome to Biblioteca. You one-stop-shop for great book titles in Bangalore!";
        System.out.println(welcomeMessage);
    }

}
