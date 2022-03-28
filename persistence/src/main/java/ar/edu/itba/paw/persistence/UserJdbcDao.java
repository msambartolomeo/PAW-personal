package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.interfaces.UserDao;
import ar.edu.itba.paw.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcDao implements UserDao {

    @Override
    public User getUserById(long id) {
        return new User(id, "PAW", "pepe");
    }
}
