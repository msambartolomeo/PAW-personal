package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.interfaces.UserDao;
import ar.edu.itba.paw.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class UserJpaDao implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<User> getUserById(long id) {
        return Optional.ofNullable(em.find(User.class, id));
    }

    @Override
    public User create(String username, String password) {
        final User user = new User(username, password);
        em.persist(user);
        return user;
    }

    @Override
    public List<User> getAll(int page) {
        final TypedQuery<User> query = em.createQuery("FROM User as u", User.class);
        query.setFirstResult(page * 10);
        query.setMaxResults(10);
        return query.getResultList();
    }

    @Override
    public Optional<User> findByName(String name) {
        final TypedQuery<User> query = em.createQuery("FROM User as u WHERE u.username = :username", User.class);
        query.setParameter("username", name);
        // return query.getResultList().stream().findFirst();
        return Optional.ofNullable(query.getSingleResult());
    }
}
