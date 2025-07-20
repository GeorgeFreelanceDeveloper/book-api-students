package pl.coderslab.bookapiworkshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.bookapiworkshop.model.Book;
import pl.coderslab.bookapiworkshop.service.BookService;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {

    private final BookService bookService;

    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String list(Model model) {
        model.addAttribute("books", bookService.getBooks());
        return "books/all";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("book", new Book());
        return "books/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Book book) {
        bookService.add(book);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        bookService.get(id).ifPresent(b -> model.addAttribute("book", b));
        return "books/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Book book) {
        bookService.update(book);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        bookService.get(id).ifPresent(b -> model.addAttribute("book", b));
        return "books/view";
    }
}