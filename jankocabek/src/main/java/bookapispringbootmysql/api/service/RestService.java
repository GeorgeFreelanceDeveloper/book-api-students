package bookapispringbootmysql.api.service;


import bookapispringbootmysql.service.BookService;
import bookapispringbootmysql.exception.BookNotFoundException;
import bookapispringbootmysql.exception.DuplicatedRecordException;
import bookapispringbootmysql.model.Book;
import bookapispringbootmysql.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class RestService {

    private final BookService bookService;
    private final BookRepository bookRepository;

    public RestService(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        if (bookService.isIsbnTaken(book.getIsbn()))
            throw new DuplicatedRecordException("Given ISBN: %s is already taken, book can't be added".formatted(book.getIsbn()));
        return bookService.addBook(book);
    }

    public Book updateBook(Book book) {
        if (!bookRepository.existsById(book.getId()))
            throw new BookNotFoundException("Book with id: %d not found and can't be updated".formatted(book.getId()));
        else if (bookService.isIsbnTakenByOtherBook(book.getId(), book.getIsbn()))
            throw new DuplicatedRecordException("ISBN: %s is already taken, book can't be updated".formatted(book.getIsbn()));
        return bookService.updateBook(book);
    }

    public void deleteBookById(Long id) {
        if (!bookRepository.existsById(id))
            throw new BookNotFoundException("Book with ID %d not found and can't be deleted".formatted(id));
        bookRepository.deleteById(id);
    }

}
