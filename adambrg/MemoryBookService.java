package pl.coderslab.bookapiworkshop;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemoryBookService {
    private final List<Book> books = new ArrayList<>();
    private long nextId = 1;

    public List<Book> getAllBooks() {
        return books;
    }

    public Optional<Book> getBookById(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    public Book addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
        return book;
    }

    public boolean updateBook(Book updatedBook) {
        Optional<Book> optional = getBookById(updatedBook.getId());
        if (optional.isPresent()) {
            Book existing = optional.get();
            existing.setIsbn(updatedBook.getIsbn());
            existing.setTitle(updatedBook.getTitle());
            existing.setPublisher(updatedBook.getPublisher());
            existing.setType(updatedBook.getType());
            existing.setAuthor(updatedBook.getAuthor());
            return true;
        }
        return false;
    }

    public boolean deleteBook(Long id) {
        return books.removeIf(book -> book.getId().equals(id));
    }
}