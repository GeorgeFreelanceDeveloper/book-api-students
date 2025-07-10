package pl.coderslab.service;

import org.springframework.http.ResponseEntity;
import pl.coderslab.model.Book;
import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBook(Long id);
    Book addBook(Book book);
    ResponseEntity<Book> updateBook(Long id, Book updatedBook);
    void deleteBook(Long id);
}