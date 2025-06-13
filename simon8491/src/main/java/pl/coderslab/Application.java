package pl.coderslab;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.controller.BookController;
import pl.coderslab.model.Book;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BookController.class);

        BookController bookController = context.getBean(BookController.class);
        List<Book> books = bookController.getBooks();
        for (Book book : books) {
            System.out.println(book);
        }

    }
}
