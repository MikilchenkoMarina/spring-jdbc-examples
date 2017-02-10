package dataBaseTests;


import inspoDataBase.jdbcUsageDataBase.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

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
}
