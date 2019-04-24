package pl.adamLupinski.springLearning.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.adamLupinski.springLearning.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public BookDaoImpl() {
    }

    public void save(Book book) {
        entityManager.persist(book);
    }

    @Transactional(readOnly = true)
    public Book get(Long id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public void update(Book book) {
        entityManager.merge(book);
    }

    @Override
    public void remove(Long bookId) {
        entityManager.remove(get(bookId));
    }
}
