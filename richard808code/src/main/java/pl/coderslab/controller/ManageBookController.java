package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;

import java.util.List;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {

    private final BookService bookService;

    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/{id}")
    public String viewBook(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getBook(id);
        if (book == null) {
            return "redirect:/admin/books/all";
        }
        model.addAttribute("book", book);
        return "books/detail";
    }

    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books/all";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "books/form";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        bookService.addBook(book);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getBook(id);
        if (book == null) {
            return "redirect:/admin/books/all";
        }
        model.addAttribute("book", book);
        return "books/form";
    }

    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, @ModelAttribute Book book) {
        bookService.updateBook(id, book);
        return "redirect:/admin/books/all";
    }
}