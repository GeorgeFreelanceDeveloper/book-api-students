package pl.coderslab.bookapiworkshop.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.bookapiworkshop.model.Book;
import pl.coderslab.bookapiworkshop.service.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final MemoryBookService memoryBookService;

    @Autowired
    public BookController(MemoryBookService memoryBookService) {
        this.memoryBookService = memoryBookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return memoryBookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return memoryBookService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return memoryBookService.addBook(book);
    }

    @PutMapping
    public ResponseEntity<?> updateBook(@RequestBody Book book) {
        boolean updated = memoryBookService.updateBook(book);
        return updated ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        boolean deleted = memoryBookService.deleteBook(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PostConstruct
    public void init() {
        addBook(new Book(null, "9780747532699", "Harry Potter and the Philosopher's Stone", "J.K. Rowling", "Bloomsbury", "Fantasy"));
        addBook(new Book(null, "9780747538493", "Harry Potter and the Chamber of Secrets", "J.K. Rowling", "Bloomsbury", "Fantasy"));
        addBook(new Book(null, "9780544003415", "The Fellowship of the Ring", "J.R.R. Tolkien", "Houghton Mifflin", "Fantasy"));
        addBook(new Book(null, "9780544003416", "The Two Towers", "J.R.R. Tolkien", "Houghton Mifflin", "Fantasy"));
        addBook(new Book(null, "9780544003417", "The Return of the King", "J.R.R. Tolkien", "Houghton Mifflin", "Fantasy"));
    }
} 
