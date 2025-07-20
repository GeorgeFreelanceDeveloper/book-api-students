package bookapispringbootmysql.service;



import bookapispringbootmysql.exception.BookNotFoundException;
import bookapispringbootmysql.model.Book;
import bookapispringbootmysql.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }


    public Book getBook(Long id) {
        final var bookResult = bookRepository.findById(id);
        return (bookResult.orElseThrow(() -> new BookNotFoundException("Book with id: %d not found".formatted(id))));
    }

    @Transactional
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public boolean isIsbnTaken(String isbn) {
        return bookRepository.findByIsbn(isbn).isPresent();
    }

    public boolean isIsbnTakenByOtherBook(Long id, String isbn) {
        return bookRepository.findByIsbn(isbn).map(book -> !book.getId().equals(id)).orElse(false);
    }
}

