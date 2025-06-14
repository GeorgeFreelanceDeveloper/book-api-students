package pl.coderslab.service;

import pl.coderslab.model.Book;
import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBook(long id);
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(long id);
}