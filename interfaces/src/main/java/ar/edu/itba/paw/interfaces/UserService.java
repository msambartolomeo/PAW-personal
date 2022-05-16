package ar.edu.itba.paw.interfaces;

import ar.edu.itba.paw.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(long id);

    User create(String username, String password);

    Optional<User> findByName(String username);

    void updateUserPassword(User user, String password);

    List<User> getAll(int page);
}
