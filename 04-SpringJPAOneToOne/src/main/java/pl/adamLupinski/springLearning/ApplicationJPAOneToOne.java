package pl.adamLupinski.springLearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.adamLupinski.springLearning.dao.UserDao;
import pl.adamLupinski.springLearning.dao.UserDaoImpl;
import pl.adamLupinski.springLearning.dao.UserDetailsDao;
import pl.adamLupinski.springLearning.model.User;
import pl.adamLupinski.springLearning.model.UserDetails;

@SpringBootApplication
public class ApplicationJPAOneToOne {

    public static void main(String[] args) throws InterruptedException {

        ConfigurableApplicationContext context = SpringApplication.run(ApplicationJPAOneToOne.class, args);

        UserDao userDao = context.getBean(UserDao.class);
        User user = new User("JohnDoe", "strongPass", "johnny@pepperoni.com");

        UserDetails details = new UserDetails("John", "Doe", "White House, Washington DC");

        // Create
        user.setDetails(details);
        userDao.save(user);

        // Read
        User readUser  = userDao.get(1L);
        System.out.println(readUser);

        // Update
        readUser.setEmail("ubijacz@smoków.com");
        readUser.getDetails().setFirstName("Szewczyk");
        readUser.getDetails().setLastName("Dratewka");
        userDao.update(readUser);
        System.out.println(userDao.get(1L));

        // with both side relations
        UserDetailsDao userDetailsDao = context.getBean(UserDetailsDao.class);
        UserDetails userDetails = userDetailsDao.get(1L);
        System.out.println(userDetails.getUser());

        // Delete
        userDao.delete(user);

        System.out.println(userDao.get(1L));


        context.close();

    }

}
