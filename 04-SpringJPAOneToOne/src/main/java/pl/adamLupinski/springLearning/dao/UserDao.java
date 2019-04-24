package pl.adamLupinski.springLearning.dao;

import pl.adamLupinski.springLearning.model.User;

public interface UserDao {

    void save(User user);
    User get(Long id);
    void update(User user);
    void delete(User user);

}
