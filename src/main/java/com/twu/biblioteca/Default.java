package com.twu.biblioteca;
import java.util.ArrayList;
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

    public List<MenuItem> getMenuItems(BookLibrary bookLibrary, MovieLibrary movieLibrary, Console console){
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new ShowBookItems(bookLibrary));
        menuItems.add(new CheckOutBookItem(bookLibrary,console));
        menuItems.add(new ReturnBookItem(bookLibrary,console));
        menuItems.add(new ShowMovieItems(movieLibrary));
        menuItems.add(new CheckOutMovieItem(movieLibrary,console));
        menuItems.add(new QuitMenu());
        return menuItems;
    }
}
