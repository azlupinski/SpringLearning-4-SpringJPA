package pl.adamLupinski.springLearning.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.adamLupinski.springLearning.model.Client;

@Repository
@Transactional
public class ClientDao extends GenericDao<Client, Long> {

    @Override
    public Client get(Long key) {

        Client client  = super.get(key);
        client.getOrders().size();
        return client;
    }
}
