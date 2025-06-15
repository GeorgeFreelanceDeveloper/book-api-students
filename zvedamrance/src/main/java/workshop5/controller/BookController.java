package workshop5.controller;

import org.springframework.web.bind.annotation.*;
import workshop5.model.Book;
import workshop5.service.MemoryBookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    final MemoryBookService bookService;

    public BookController(MemoryBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("")
    public boolean addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteBookById(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }

    @PutMapping("/{id}")
    public boolean updateBookById(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }
}



