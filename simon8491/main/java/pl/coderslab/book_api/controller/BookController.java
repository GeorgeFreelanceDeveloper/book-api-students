package pl.coderslab.book_api.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.book_api.model.Book;
import pl.coderslab.book_api.service.BookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    @PostMapping("")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }
    @GetMapping("{id}")
    public Book getBook(@PathVariable Long id) {
        return this.bookService.getBook(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with id: " + id + " not found"));
    }
    @PutMapping("")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        var updatedBook = bookService.updateBook(book);
        return updatedBook.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        var deleted = bookService.deleteBook(id);
        return deleted ? ResponseEntity.noContent().build():ResponseEntity.notFound().build();
    }
}
