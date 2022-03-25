package ar.edu.itba.paw.service;

import ar.edu.itba.paw.interfaces.UserService;
import ar.edu.itba.paw.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final User user;

    UserServiceImpl() {
        user = new User("PAW");
    }

    @Override
    public String getUsername() {
        return user.getName();
    }
}
