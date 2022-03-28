package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.interfaces.UserDao;
import ar.edu.itba.paw.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserJdbcDao implements UserDao {

    @Autowired
    public UserJdbcDao(final DataSource ds){
        // TODO ds
    }

    @Override
    public User getUserById(long id) {
        return new User(id, "PAW", "pepe");
    }
}
