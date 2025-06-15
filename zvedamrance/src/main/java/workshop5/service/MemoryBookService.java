package workshop5.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import workshop5.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemoryBookService {
    private List<Book> books;

    @PostConstruct
    public void init() {
        books = new ArrayList<>(List.of(
                new Book(1L, "9780141182636", "1984", "George Orwell", "Penguin", "Dystopia"),
                new Book(2L, "9780060850524", "Brave New World", "Aldous Huxley", "Harper", "Dystopia"),
                new Book(3L, "9780743273565", "The Great Gatsby", "F. Scott Fitzgerald", "Scribner", "Classic"),
                new Book(4L, "9780141439600", "Pride and Prejudice", "Jane Austen", "Penguin", "Romance"),
                new Book(5L, "9780451524935", "Animal Farm", "George Orwell", "Signet", "Satire"),
                new Book(6L, "9780307277671", "The Road", "Cormac McCarthy", "Vintage", "Post-apocalyptic"),
                new Book(7L, "9780590353427", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Scholastic", "Fantasy"),
                new Book(8L, "9780261103573", "The Hobbit", "J.R.R. Tolkien", "HarperCollins", "Fantasy"),
                new Book(9L, "9780553380163", "A Game of Thrones", "George R.R. Martin", "Bantam", "Fantasy"),
                new Book(10L, "9780143128540", "The Catcher in the Rye", "J.D. Salinger", "Little, Brown", "Fiction")
        ));
    }
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public Optional<Book> getBookById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }

    public boolean updateBook(Long id, Book updatedBook) {
        Optional<Book> existing = getBookById(id);
        if (existing.isPresent()) {
            Book book = existing.get();
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setIsbn(updatedBook.getIsbn());
            book.setPublisher(updatedBook.getPublisher());
            book.setType(updatedBook.getType());
            return true;
        }
        return false;
    }

    public boolean addBook(Book book) {
        Optional<Book> existing = getBookById(book.getId());
        if (existing.isPresent()) {
            return false;
        }
        books.add(book);
        return true;
    }

    public boolean deleteBook(Long id) {
        return books.removeIf(book -> book.getId().equals(id));
    }
}
