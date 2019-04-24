package pl.adamLupinski.springLearning.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "client_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    // one site relation
//    @ManyToMany
//    @Column(nullable = false)
//    private List<Product> products;

    @ManyToMany
    @JoinTable(name = "order_products",
    joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "order_id")},
    inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "product_id")})
    @Column(nullable = false)
    private List<Product> products;
    @Column(name = "details", length = 512)
    private String orderDetails;

//    for one to many both side
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Order() {
    }

    public Order(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", products=" + products +
                ", orderDetails='" + orderDetails + '\'' +
                ", client=" + client.getFirstName() + " " + client.getLastName() +
                '}';
    }
}
