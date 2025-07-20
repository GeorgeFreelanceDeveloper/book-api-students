package pl.coderslab.book_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.book_api.entity.Book;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String title);
}
