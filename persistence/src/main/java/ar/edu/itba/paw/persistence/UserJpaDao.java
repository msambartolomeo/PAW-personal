package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.interfaces.UserDao;
import ar.edu.itba.paw.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        final Query idQuery = em.createNativeQuery("SELECT userid FROM users LIMIT 10 OFFSET :offset");
        idQuery.setParameter("offset", page * 10);
        @SuppressWarnings("unchecked")
        List<Long> ids = (List<Long>) idQuery.getResultList().stream().map(o -> ((Integer) o).longValue()).collect(Collectors.toList());

        final TypedQuery<User> query = em.createQuery("FROM User WHERE userId IN :ids", User.class);
        query.setParameter("ids", ids);

        return query.getResultList();
    }

    @Override
    public Optional<User> findByName(String name) {
        final TypedQuery<User> query = em.createQuery("FROM User as u WHERE u.username = :username", User.class);
        query.setParameter("username", name);
        // return query.getResultList().stream().findFirst();
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public User merge(User user) {
        return em.merge(user);
    }
}
