package pl.coderslab.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    // injection by constructor
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }
    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }
    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return this.bookService.getBook(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
    }
    @PutMapping("")
    public void updateBook(@RequestBody Book book) {
        this.bookService.updateBook(book);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        this.bookService.deleteBook(id);
    }
}
