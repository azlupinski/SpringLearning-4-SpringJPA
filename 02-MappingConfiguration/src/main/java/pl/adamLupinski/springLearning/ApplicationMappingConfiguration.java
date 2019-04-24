package pl.adamLupinski.springLearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.adamLupinski.springLearning.dao.BookDao;
import pl.adamLupinski.springLearning.model.Book;

@SpringBootApplication
public class ApplicationMappingConfiguration {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(ApplicationMappingConfiguration.class, args);
        BookDao bookDao = context.getBean(BookDao.class);
        Book book = new Book("0987123409876", "Księga wszystkich dokonań Sherlocka Holmesa", "Sir Arthur Conan Doyle");
        bookDao.save(book);

        System.out.println(bookDao.get(1L));
    }

}
