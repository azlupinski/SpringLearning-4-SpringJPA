package pl.adamLupinski.springLearning.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.adamLupinski.springLearning.model.Order;

@Repository
@Transactional
public class OrderDao extends GenericDao<Order, Long> {
}
