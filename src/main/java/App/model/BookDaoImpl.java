package App.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceUnit
    private EntityManagerFactory emFactory;

    public BookDaoImpl() {
    }

    @Override
    public void save(Book book) {
        EntityManager enManager = emFactory.createEntityManager();
        EntityTransaction tx = enManager.getTransaction();
        tx.begin();
        enManager.persist(book);
        tx.commit();
        enManager.close();
    }

    @Override
    public Book get(Long id) {
        EntityManager entityManager = emFactory.createEntityManager();
        Book book = entityManager.find(Book.class, id);
        entityManager.close();
        return book;
    }
}
