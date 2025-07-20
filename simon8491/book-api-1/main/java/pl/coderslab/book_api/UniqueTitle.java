package pl.coderslab.book_api;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueTitleValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueTitle {
    String message() default "book.title.unique";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
