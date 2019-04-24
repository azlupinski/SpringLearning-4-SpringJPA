package pl.adamLupinski.springLearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.adamLupinski.springLearning.dao.ClientDao;
import pl.adamLupinski.springLearning.dao.OrderDao;
import pl.adamLupinski.springLearning.dao.ProductDao;
import pl.adamLupinski.springLearning.model.Client;
import pl.adamLupinski.springLearning.model.Order;
import pl.adamLupinski.springLearning.model.Product;

@SpringBootApplication
public class ApplicationManyToMany {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(ApplicationManyToMany.class, args);

        Client client = new Client("Adam", "Lupinski", "Heroiczna 5, Zamek");
        ClientDao clientDao = context.getBean(ClientDao.class);

        clientDao.save(client);
        System.out.println(client);

        Order order = new Order(" Wszystkie jednostki ulepszone jeżeli wystarczy środków");
        order.setClient(client);
        OrderDao orderDao = context.getBean(OrderDao.class);
        orderDao.save(order);

        Product product1= new Product("Czarne smoki", 4000.0, "jednostka latająca, ziejąca ogniem, odporne na czary");
        Product product2= new Product("Czerwone smoki", 3500.0, "jednostka latająca, ziejąca ogniem");
        ProductDao productDao = context.getBean(ProductDao.class);
        productDao.save(product1);
        productDao.save(product2);

        orderDao.addProductsToOrder(order.getId(), product1, product2);

        context.close();


    }

}
