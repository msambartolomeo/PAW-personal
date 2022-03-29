package ar.edu.itba.paw.service;

import ar.edu.itba.paw.interfaces.UserDao;
import ar.edu.itba.paw.interfaces.UserService;
import ar.edu.itba.paw.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    UserServiceImpl(final UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Optional<User> getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public User create(String username, String password) {
        // TODO validate username and password
        return userDao.create(username, password);
    }
}
