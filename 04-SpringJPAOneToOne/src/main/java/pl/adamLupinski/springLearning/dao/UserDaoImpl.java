package pl.adamLupinski.springLearning.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.adamLupinski.springLearning.model.User;
import pl.adamLupinski.springLearning.model.UserDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

//    @Autowired
//    public UserDaoImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    @Override
    public void save(User user) {
        UserDetails details = user.getDetails();
        if (details != null && details.getId()==null) entityManager.persist(details);
        entityManager.persist(user);
    }

    @Override
    public User get(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(User user) {
        UserDetails details = user.getDetails();
        if (details != null) {
           details = entityManager.merge(details);
           user.setDetails(details);
        }
        entityManager.merge(user);
    }

    @Override
    public void delete(User user) {
        User userToDelete = entityManager.merge(user);
        entityManager.remove(userToDelete.getDetails());
        entityManager.remove(userToDelete);
    }
}
