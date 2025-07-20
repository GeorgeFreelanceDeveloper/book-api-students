package pl.coderslab.book_api;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.coderslab.book_api.entity.Book;
import pl.coderslab.book_api.repository.BookRepository;

@Component
@RequiredArgsConstructor
public class UniqueTitleValidator implements ConstraintValidator<UniqueTitle, Book> {
    private final BookRepository bookRepository;

    @Override
    public boolean isValid(Book book, ConstraintValidatorContext context) {
        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            return true;
        }
        return bookRepository.findByTitle(book.getTitle())
                .map(exists -> exists.getId().equals(book.getId())) // same book? then OK
                .orElse(true); //not found? ten OK
    }
}
