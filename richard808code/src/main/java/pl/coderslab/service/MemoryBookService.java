package pl.coderslab.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemoryBookService implements BookService {

    private List<Book> list;
    private static Long nextId = 4L;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9780099448822", "Norwegian Wood", "Haruki Murakami", "Vintage", "fiction"));
        list.add(new Book(2L, "9780805209990", "The Trial", "Franz Kafka", "Schocken Books", "classic"));
        list.add(new Book(3L, "9780061148521", "The Unbearable Lightness of Being", "Milan Kundera", "Harper Perennial", "philosophical fiction"));
    }

    public List<Book> getAllBooks() {
        return list;
    }

    public Book getBook(Long id) {
        return list.stream()
                .filter(book -> id.equals(book.getId()))
                .findFirst()
                .orElse(null);
    }

    public Book addBook(Book book) {
        book.setId(nextId++);
        list.add(book);
        return book;
    }

    public ResponseEntity<Book> updateBook(Long id, Book updatedBook) {
        Optional<Book> existing = list.stream()
                .filter(book -> id.equals(book.getId()))
                .findFirst();

        if (existing.isPresent()) {
            Book book = existing.get();
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setIsbn(updatedBook.getIsbn());
            book.setPublisher(updatedBook.getPublisher());
            book.setType(updatedBook.getType());
            return ResponseEntity.ok(book);
        }
        return ResponseEntity.notFound().build();
    }

    public void deleteBook(Long id) {
        list.removeIf(book -> id.equals(book.getId()));
    }
}