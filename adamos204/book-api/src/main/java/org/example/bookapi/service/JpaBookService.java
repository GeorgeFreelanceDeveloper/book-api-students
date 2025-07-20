package org.example.bookapi.service;

import org.example.bookapi.model.Book;
import org.example.bookapi.repository.BookRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class JpaBookService implements BookService{

    private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }

    @Override
    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book){
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id){
       bookRepository.deleteById(id);
    }
}
