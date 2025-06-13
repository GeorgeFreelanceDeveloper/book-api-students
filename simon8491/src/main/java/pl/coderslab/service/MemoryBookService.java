package pl.coderslab.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemoryBookService implements BookService {
    @Getter
    @Setter
    private List<Book> bookList;
    @Getter
    private static Long nextId = 4L;

    public MemoryBookService() {
        bookList = new ArrayList<>();
        bookList.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));
        bookList.add(new Book(2L, "9788324627738", "Head first Java", "Sierra Kathy, Bates Bert", "Helion", "programming"));
        bookList.add(new Book(3L, "9780130819338", "Core Java 2", "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }
    @Override
    public List<Book> getBooks() {
        return bookList;
    }
    @Override
    public void addBook(Book book) {
        book.setId(nextId++);
        bookList.add(book);
    }
    @Override
    public Optional<Book> getBook(Long id) {
        return bookList
                .stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }
    @Override
    public void updateBook(Book book) {
        if (this.getBook(book.getId()).isPresent()) {
            int indexInList = bookList.indexOf(this.getBook(book.getId()).get());
            bookList.set(indexInList, book);
        }
    }
    @Override
    public void deleteBook(Long id) {
        bookList.removeIf(book -> book.getId().equals(id));
    }
}
