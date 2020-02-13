package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Default {
    public List<Book> getDefaultBooks() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Book1", "Author1", "1997"));
        bookList.add(new Book("Book2", "Author2", "1998"));
        return bookList;
    }

    public List<Movie> getDefaultMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Movie1", "2000", "Director1", "10"));
        movies.add(new Movie("Movie2", "2001", "Director2", "9"));
        return movies;
    }

    public List<String> getMenu() {
        return List.of("List of Books", "Check Out Book", "Return a book", "Quit");
    }

    public HashMap<Integer, MenuItem> getMenuItems(BookLibrary bookLibrary, MovieLibrary movieLibrary, Console console){
        HashMap<Integer, MenuItem> menuItems = new HashMap<>();
        menuItems.put(1,new ShowBookItems(bookLibrary));
        menuItems.put(2,new CheckOutBookItem(bookLibrary,console));
        menuItems.put(3,new ReturnBookItem(bookLibrary,console));
        menuItems.put(4,new ShowMovieItems(movieLibrary));
        menuItems.put(5,new CheckOutMovieItem(movieLibrary,console));
        menuItems.put(6,new QuitMenu());
        return menuItems;
    }
}
