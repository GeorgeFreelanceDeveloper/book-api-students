package pl.coderslab.book_api.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.coderslab.book_api.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemoryBookService implements BookService {
    @Setter
    private List<Book> books;
    private static Long nextId = 4L;

    // constructor for creating a Book list
    public MemoryBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));
        books.add(new Book(2L, "9788324627738", "Head first Java", "Sierra Kathy, Bates Bert", "Helion", "programming"));
        books.add(new Book(3L, "9780130819338", "Core Java 2", "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }
    @Override
    public List<Book> getAllBooks() {
        return books;
    }
    @Override
    public Book addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
        return book;
    }
    @Override
    public Optional<Book> getBook(Long id) {
        return books
                .stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }
    @Override
    public Optional<Book> updateBook(Book book) {
        final var updatedBookOpt = getBook(book.getId());
        // call getBook method defined above
        if (updatedBookOpt.isPresent()) {
            // if such a book is present,
            final var updatedBook = updatedBookOpt.get();
            updatedBook.setIsbn(book.getIsbn());
            updatedBook.setTitle(book.getTitle());
            updatedBook.setAuthor(book.getAuthor());
            updatedBook.setPublisher(book.getPublisher());
            updatedBook.setType(book.getType());
            return Optional.of(book);
        } else {
            return Optional.empty();
        }
    }
    @Override
    public boolean deleteBook(Long id) {
        return books.removeIf(book -> book.getId().equals(id));
    }
}
