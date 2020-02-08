package com.twu.biblioteca;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {
    private String welcomeMessage = "Welcome to Biblioteca. You one-stop-shop for great book titles in Bangalore!";
    private List<Book> bookList = Arrays.asList(new Book("Book1", "Author1", "1997"),
                                                new Book("Book2", "Author2", "1998"));

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
        bibliotecaApp.displayAllBooks();
    }

    private void start() {
        System.out.println(welcomeMessage);
    }

    private void displayAllBooks() {
        for (Book book : bookList) {
            System.out.print(book.getBookName());
            System.out.print(" ");
            System.out.print(book.getAuthorName());
            System.out.print(" ");
            System.out.print(book.getYear());
            System.out.println("");
        }
    }


}
