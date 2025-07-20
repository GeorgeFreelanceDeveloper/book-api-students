package org.example.bookapi.controller;

import jakarta.validation.Valid;
import org.example.bookapi.model.Book;
import org.example.bookapi.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {
    private final BookService bookService;

    public ManageBookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String showBooks(Model model){
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books/all";
    }

    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("book", new Book());
        return "books/add";
    }

    @PostMapping("/add")
    public String handleAddBookForm(@Valid @ModelAttribute Book book, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "books/add";
        }

        bookService.addBook(book);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
            return "books/edit";
        } else {
            return "books/booknotfound";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateBook(@Valid @ModelAttribute Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "books/edit";
        }
        bookService.updateBook(book);
        return "redirect:/admin/books/all";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/{id}")
    public String showBook(@PathVariable Long id, Model model) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
            return "books/show";
        } else {
            return "booknotfound";
        }
    }
}
