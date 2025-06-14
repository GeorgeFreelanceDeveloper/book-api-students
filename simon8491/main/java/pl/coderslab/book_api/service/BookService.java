package pl.coderslab.book_api.service;

import pl.coderslab.book_api.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getAllBooks();

    void addBook(Book book);

    Optional<Book> getBook(Long id);

    void updateBook(Book book);

    void deleteBook(Long id);
}
