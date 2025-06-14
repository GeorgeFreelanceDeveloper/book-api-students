package pl.coderslab.book_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.book_api.model.Book;
import pl.coderslab.book_api.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }
    @GetMapping("{id}")
    public Book getBook(@PathVariable Long id) {
        return this.bookService.getBook(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with id: " + id + " not found"));
    }
    @PutMapping("")
    public void updateBook(@RequestBody Book book) {
        this.bookService.updateBook(book);
    }
    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable Long id) {
        this.bookService.deleteBook(id);
    }
}
