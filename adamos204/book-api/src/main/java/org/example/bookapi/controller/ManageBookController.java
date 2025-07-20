package org.example.bookapi.controller;

import org.example.bookapi.model.Book;
import org.example.bookapi.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String handleAddBookForm(@ModelAttribute Book book){
        bookService.addBook(book);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/{id}")
    public String showBook(@PathVariable Long id, Model model){
        Book book = bookService.getBookById(id).orElse(null);
        model.addAttribute("book", book);
        return "books/show";
    }
}
