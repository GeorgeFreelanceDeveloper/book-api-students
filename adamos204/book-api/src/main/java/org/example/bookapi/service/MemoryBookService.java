package org.example.bookapi.service;

import org.example.bookapi.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryBookService implements BookService{
    List<Book> books;

    public MemoryBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));
        books.add(new Book(2L, "9780132350884", "Clean Code", "Robert C. Martin", "Prentice Hall", "programming"));
    }

    public List<Book> getAllBooks(){
        return books;
    }

    public void addBook(Book book){
        long newId = books.stream()
                .mapToLong(Book::getId)
                .max()
                .orElse(0L) + 1;
        book.setId(newId);
        books.add(book);
    }

    public Book getBookById(Long id){
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public boolean updateBook(Book updatedBook){
        for (int i = 0; i < books.size(); i++){
            Book book = books.get(i);
            if (book.getId().equals(updatedBook.getId())){
                books.set(i, updatedBook);
                return true;
            }
        }
        return false;
    }

    public boolean deleteBook(Long id){
        return books.removeIf(book -> book.getId().equals(id));
    }

}
