package inspoDataBase.jdbcUsageDataBase;

import inspoDataBase.jdbcUsageDataBase.dao.UserDao;
import inspoDataBase.jdbcUsageDataBase.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Andy on 09.02.2017.
 */
public class Test {
    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("InspoMinderDataBaseConfig.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");

        User userMarina = new User(4, "TestMar", "333");
        userDao.addUser(userMarina);
    }
}
