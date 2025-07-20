package org.example.bookapi.service;

import org.example.bookapi.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemoryBookService_temp implements BookService{
    List<Book> books;

    public MemoryBookService_temp() {
        books = new ArrayList<>();
    }

    public List<Book> getAllBooks(){
        return books;
    }

    public Book addBook(Book book){
        long newId = books.stream()
                .mapToLong(Book::getId)
                .max()
                .orElse(0L) + 1;
        book.setId(newId);
        books.add(book);
        return book;
    }

    public Optional<Book> getBookById(Long id){
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }

    public Book updateBook(Book updatedBook){
        for (int i = 0; i < books.size(); i++){
            Book book = books.get(i);
            if (book.getId().equals(updatedBook.getId())){
                books.set(i, updatedBook);
            }
        }
        return updatedBook;
    }

    public void deleteBook(Long id){
        books.removeIf(book -> book.getId().equals(id));
    }

}
