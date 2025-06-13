package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;

public class Book {
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String isbn;
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private String author;
    @Getter
    @Setter
    private String publisher;
    @Getter
    @Setter
    public String type;

    public Book() {}

    public Book(Long id, String isbn, String title, String author, String publisher, String type) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.type = type;
    }
}
