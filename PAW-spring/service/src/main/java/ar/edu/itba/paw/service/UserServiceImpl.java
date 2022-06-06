package ar.edu.itba.paw.service;

import ar.edu.itba.paw.interfaces.UserDao;
import ar.edu.itba.paw.interfaces.UserService;
import ar.edu.itba.paw.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public Optional<User> getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public User create(String username, String password) {
        // TODO validate username and password
        return userDao.create(username, passwordEncoder.encode(password));
    }

    @Override
    public Optional<User> findByName(String username) {
        return userDao.findByName(username);
    }

    @Transactional
    @Override
    public void updateUserPassword(User user, String password) {
        user = userDao.merge(user);
        user.setPassword(passwordEncoder.encode(password));
    }

    @Override
    public List<User> getAll(int page) {
        return userDao.getAll(page);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        userDao.deleteById(id);
    }
}
