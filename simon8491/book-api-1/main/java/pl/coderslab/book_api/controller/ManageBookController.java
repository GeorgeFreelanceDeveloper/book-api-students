package pl.coderslab.book_api.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.book_api.entity.Book;
import pl.coderslab.book_api.repository.BookRepository;

import java.util.Optional;

@Controller
@RequestMapping("/admin/books")
@RequiredArgsConstructor
public class ManageBookController {
    private final BookRepository bookRepository;
// All books
    @GetMapping("/all")
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "books/all";
    }
// Add book
    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("form", "/admin/books/add");
        return "books/add";
    }

    @PostMapping("/add")
    public String addBook(@Valid Book book, BindingResult bindingResult) {
        if (bookRepository.findByTitle(book.getTitle()).isPresent()) {
            bindingResult.rejectValue("title", "book.title.unique", "Title already exists");
        }
        if (bindingResult.hasErrors()) {
            return "books/add";
        }
        bookRepository.save(book);
        return "redirect:/admin/books/all";
    }
// Edit book
    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model) {
        Book book = bookRepository.findById(id).orElse(null);
        model.addAttribute("book", book);
        model.addAttribute("form", "/admin/books/edit/");
        return "books/edit";
    }

    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, @Valid Book book, BindingResult bindingResult) {
        Optional<Book> existing = bookRepository.findByTitle(book.getTitle());
        if (existing.isPresent() && !existing.get().getId().equals(id)) {
            bindingResult.rejectValue("title", "book.title.unique", "Title already exists");
        }
        if (bindingResult.hasErrors()) {
            return "books/edit";
        }
        book.setId(id);
        bookRepository.save(book);
        return "redirect:/admin/books/all";
    }
// Delete book
    @GetMapping("delete/{id}")
    public String deleteConfirm(@PathVariable Long id, Model model) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            return "redirect:/admin/books/all";
        }
        model.addAttribute("book", book);
        return "books/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/admin/books/all";
    }
// Show book details
    @GetMapping("/show/{id}")
    public String getBookDetails(@PathVariable Long id, Model model) {
        Book book = bookRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        if (book == null) {
            return "redirect:/admin/books/all";
        }
        model.addAttribute("book", book);
        return "books/details";
    }
}
