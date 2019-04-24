package pl.adamLupinski.springLearning.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.adamLupinski.springLearning.model.Product;

@Repository
@Transactional
public class ProductDao extends GenericDao<Product, Long> {
}
