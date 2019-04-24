package pl.adamLupinski.springLearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.adamLupinski.springLearning.dao.ClientDao;
import pl.adamLupinski.springLearning.dao.OrderDao;
import pl.adamLupinski.springLearning.model.Client;
import pl.adamLupinski.springLearning.model.Order;

@SpringBootApplication
public class ApplicationManyToOneAndOneToMany {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(ApplicationManyToOneAndOneToMany.class, args);

        Client client = new Client("Adam", "Lupinski", "Heroiczna 5, Zamek");
        ClientDao clientDao = context.getBean(ClientDao.class);

        clientDao.save(client);
        System.out.println(client);

        Order order = new Order("Czarne smoki","Latająca, zasięg ataku kilka pól, odporna na magie");
        order.setClient(client);
        OrderDao orderDao = context.getBean(OrderDao.class);
        orderDao.save(order);

        Order getOrder = orderDao.get(1L);
        Client getClient = clientDao.get(1L);
        System.out.println(getOrder);
        System.out.println(getClient);

        context.close();
    }

}
