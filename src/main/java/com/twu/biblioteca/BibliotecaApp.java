package com.twu.biblioteca;
import java.util.*;

public class BibliotecaApp {
    private String welcomeMessage = "Welcome to Biblioteca. You one-stop-shop for great book titles in Bangalore!";
    private List<Book> bookList = Arrays.asList(new Book("Book1", "Author1", "1997"),
                                                new Book("Book2", "Author2", "1998"));
    private HashMap<Integer, String> menuList = new HashMap<>();
    private int userInput;

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.menuList.put(1,"List of Books");

        bibliotecaApp.start();
        bibliotecaApp.showMenu();

        if(bibliotecaApp.getUserInput().equals("1"))
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

    private void showMenu(){
        for(Map.Entry<Integer, String> entry : menuList.entrySet())
            System.out.print(entry.getKey() + ". " + entry.getValue());
        System.out.println("\nPlease choose option : ");
    }

    public String getUserInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}
