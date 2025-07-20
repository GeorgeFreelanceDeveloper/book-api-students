package pl.coderslab.bookapiworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.bookapiworkshop.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {}
