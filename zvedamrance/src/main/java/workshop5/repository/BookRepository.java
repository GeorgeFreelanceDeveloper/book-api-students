package workshop5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import workshop5.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
