package ar.edu.itba.paw.service;

import ar.edu.itba.paw.interfaces.UserDao;
import ar.edu.itba.paw.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao user;

    @Autowired
    UserServiceImpl(final UserDao userDao) {
        this.user = userDao;
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
}
