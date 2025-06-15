package pl.coderslab.bookapiworkshop.service;

import org.springframework.stereotype.Service;
import pl.coderslab.bookapiworkshop.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MemoryBookService {
    private final List<Book> books = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    public MemoryBookService() {
        books.add(new Book(counter.getAndIncrement(), "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Optional<Book> getBookById(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    public Book addBook(Book book) {
        book.setId(counter.getAndIncrement());
        books.add(book);
        return book;
    }

    public Optional<Book> updateBook(Book updatedBook) {
        return getBookById(updatedBook.getId()).map(existingBook -> {
            existingBook.setIsbn(updatedBook.getIsbn());
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setPublisher(updatedBook.getPublisher());
            existingBook.setType(updatedBook.getType());
            return existingBook;
        });
    }

    public boolean deleteBook(Long id) {
        return books.removeIf(book -> book.getId().equals(id));
    }
}
