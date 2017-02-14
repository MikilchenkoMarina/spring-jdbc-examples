package dataBaseTests;


import inspoDataBase.jdbcUsageDataBase.dao.UserDao;
import inspoDataBase.jdbcUsageDataBase.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Marina on 10.02.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:InspoMinderDataBaseConfig.xml")
public class inspoDataTest {
    @Autowired
    public UserDao userDao;

    @Test
    public void checkThatUserBeanIsCreated() {
        assertNotNull(userDao);
    }

    @Test
    public void chectAddUserMethod() {
        User testUser = new User(11, "TestUser", "333");
        userDao.addUser(testUser);
        assertNotNull(userDao.getUserById(11));
    }

    @Test
    public void deleteUserMethodTests() {
        assertNotNull(userDao.getUserById(11));
        userDao.deleteUserById(11);
        assertNull(userDao.getUserById(11));
    }
}
