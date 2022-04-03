package ar.edu.itba.paw.service;

import ar.edu.itba.paw.interfaces.UserDao;
import ar.edu.itba.paw.model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class UserServiceImplTest {

    private UserServiceImpl userService;
    private UserDao userDao;

    @Before
    public void setUp() {
        userDao = Mockito.mock(UserDao.class);
        // devuelve valores default
        // nullable => null
        // Number => 0
        // boolean => false
        userService = new UserServiceImpl();
    }

    @Test
    public void testCreateUser() {
        User user = new User(1, "juan", "1234");
        Mockito.when(userDao.create(Mockito.anyString(), Mockito.anyString())).thenReturn(user);


        User u = userService.create("juan", "1234");
    }
}
