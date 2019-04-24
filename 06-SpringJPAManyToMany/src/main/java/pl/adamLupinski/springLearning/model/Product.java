package pl.adamLupinski.springLearning.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "details")
    private  String details;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

    public Product() {
    }

    public Product(String name, Double price, String details, List<Order> orders) {
        this.name = name;
        this.price = price;
        this.details = details;
        this.orders = orders;
    }

    public Product(String name, Double price, String details) {
        this.name = name;
        this.price = price;
        this.details = details;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", details='" + details + '\'' +
                ", number_of_orders=" + orders.size() +
                '}';
    }
}
