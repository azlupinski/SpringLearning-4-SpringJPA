package pl.adamLupinski.springLearning.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "books")
public class Book implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private Long id;

    @Column(nullable = false, length = 13, unique = true)
    private String isbn;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    public Book(){}

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public Long getId() {
        System.out.println(">>>>>>>Get Id");
        return id;
    }

    public void setId(Long id) {
        System.out.println(">>>>>>>Set Id");
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
