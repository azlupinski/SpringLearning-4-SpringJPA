package pl.adamLupinski.springLearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.adamLupinski.springLearning.dao.BookDao;
import pl.adamLupinski.springLearning.model.Book;

@SpringBootApplication
public class ApplicationCRUD {

    public static void main(String[] args) {

        ConfigurableApplicationContext context =SpringApplication.run(ApplicationCRUD.class, args);


        // CREATE
        BookDao dao = context.getBean(BookDao.class);
        Book book = new Book("1234567890468", "Spring is so cool", "Javastart");
        dao.save(book);

        // UPDATE
        Book book2 = new Book("987654321", "Spring is NOT so cool", "Javastart");
        book2.setId(1L);
        dao.update(book2);

        // READ
        Book findBook = dao.get(1L);
        System.out.println(findBook);

        // DELETE
        dao.remove(1L);
        Book book3 = dao.get(1L);
        System.out.println(book3); //null
    }

}
