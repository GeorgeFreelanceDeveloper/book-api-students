package org.example.bookapi.service;

import org.example.bookapi.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    void addBook(Book book);
    boolean updateBook(Book book);
    boolean deleteBook(Long id);
}
