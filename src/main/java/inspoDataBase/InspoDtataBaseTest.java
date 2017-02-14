package inspoDataBase;

import inspoDataBase.jdbcUsageDataBase.dao.UserDao;
import inspoDataBase.jdbcUsageDataBase.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Andy on 09.02.2017.
 */
public class InspoDtataBaseTest {
    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("InspoMinderDataBaseConfig.xml");
        UserDao userDao = (UserDao) context.getBean("jdbcUserDao");

        // Test Add User
        User userMarina = new User(5, "TestMar", "333");
        userDao.addUser(userMarina);

        // Test Delete User
        userDao.deleteUserById(1);

        // Test Select by Id User
        userDao.getUserById(2);

        // Test Show all users User
        List<User> allUsersList = userDao.getAllUsers();
        for (User user : allUsersList) {
            System.out.println(user.toString());
        }

    }
}
