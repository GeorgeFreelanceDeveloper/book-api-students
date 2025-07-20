package org.example.bookapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    @NotBlank(message = "Title must not be blank")
    @Size(min = 4, message = "Must have a minimum size of 4")
    private String title;
    @NotBlank(message = "Author must not be blank")
    @Size(min = 4, message = "Must have a minimum size of 4")
    private String author;
    private String publisher;
    private String type;
}
