package pl.adamLupinski.springLearning.model;



import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String isbn;

    @Transient
    private String title;

    private String author;

    public Book(){}

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }
//    @Id
//    @GeneratedValue
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
//    @Transient
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
