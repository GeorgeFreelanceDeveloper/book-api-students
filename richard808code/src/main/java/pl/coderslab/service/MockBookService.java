package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockBookService implements BookService {

    private List<Book> list;
    private static Long nextId = 4L;

    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "Norwegian Wood", "Haruki Murakami", "Vintage", "fiction"));
        list.add(new Book(2L, "The Trial", "Franz Kafka", "Schocken Books", "classic"));
        list.add(new Book(3L, "The Unbearable Lightness of Being", "Milan Kundera", "Harper Perennial", "philosophical fiction"));
    }

    public List <Book> getAllBooks(){
        return list;
    }

    public Book getBook(long id) {
        return list.stream()
                .filter (book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addBook(Book book) {
        book.setId(nextId++);
        list.add(book);
    }

    public void updateBook(Book book) {
        for (int i =0; i<list.size(); i++){
            if(list.get(i).getId() == book.getId()){
                list.set(i,book);
                break;
            }
        }
    }

    public void deleteBook(long id) {
        list.removeIf(book -> book.getId() == id);
    }
}