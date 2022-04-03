package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.model.User;
import org.hsqldb.jdbc.JDBCDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.test.jdbc.JdbcTestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;

public class UserJdbcDaoTest {

    private UserJdbcDao userDao;
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;
    private final static String USERNAME = "juan";
    private final static String PASSWORD = "1234";
    private final static String USER_TABLE = "users";
    private final static String ID = "userid";

    @Before
    public void setUp() {
        final SimpleDriverDataSource ds = new SimpleDriverDataSource();
        ds.setDriverClass(JDBCDriver.class);

        ds.setUrl("jdbc:hsqldb:mem:paw");
        ds.setUsername("ha");
        ds.setPassword("");

        userDao = new UserJdbcDao(ds);
        jdbcTemplate = new JdbcTemplate(ds);
        jdbcInsert = new SimpleJdbcInsert(ds).withTableName(USER_TABLE).usingGeneratedKeyColumns(ID);
        jdbcTemplate.execute("CREATE TABLE " + USER_TABLE + " (" +
                ID + " INTEGER IDENTITY PRIMARY KEY," +
                "username varchar(100) UNIQUE NOT NULL," +
                "password varchar(100) NOT NULL" +
                ")");
    }

    @After
    public void tearDown() {
        JdbcTestUtils.dropTables(jdbcTemplate, USER_TABLE);
    }

    @Test
    public void testCreateUser() {
        User user = userDao.create(USERNAME, PASSWORD);

        assertNotNull(user);
        assertEquals(USERNAME, user.getUsername());
        assertEquals(1, JdbcTestUtils.countRowsInTable(jdbcTemplate, USER_TABLE));
    }

    @Test
    public void testGetUserByIdDoesntExist() {
        //1. setup
        JdbcTestUtils.deleteFromTables(jdbcTemplate, USER_TABLE);
        final Map<String, Object> userData = new HashMap<>();
        userData.put("username", USERNAME);
        userData.put("password", PASSWORD);
        Number key = jdbcInsert.executeAndReturnKey(userData);

        //2. execution (1 method)
        Optional<User> user = userDao.getUserById(key.longValue());

        //3. assertion
        assertTrue(user.isPresent());
        assertEquals(USERNAME, user.get().getUsername());
    }
}
