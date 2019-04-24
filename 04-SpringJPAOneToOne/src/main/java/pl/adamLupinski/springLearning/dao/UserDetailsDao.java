package pl.adamLupinski.springLearning.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.adamLupinski.springLearning.model.UserDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class UserDetailsDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDetails get(Long id){
        return entityManager.find(UserDetails.class, id);
    }
}
