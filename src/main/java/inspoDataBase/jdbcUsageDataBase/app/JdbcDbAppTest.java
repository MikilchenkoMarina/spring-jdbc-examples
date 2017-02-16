package inspoDataBase.jdbcUsageDataBase.app;

import inspoDataBase.dao.ReminderDao;
import inspoDataBase.dao.UserDao;
import inspoDataBase.jdbcUsageDataBase.entity.ReminderEntity;
import inspoDataBase.jdbcUsageDataBase.entity.UserEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by mmikilchenko on 09.02.2017.
 */
public class JdbcDbAppTest {
    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("InspoMinderDataBaseConfig.xml");
        UserDao userDao = (UserDao) context.getBean("jdbcUserDao");

        // Test Add User
        UserEntity userMarina = new UserEntity(987, "11TestMar", "333");
        userDao.addUser(userMarina);

        // Test Show all users User
        List<UserEntity> allUsersList = userDao.getAllUsers();
        for (UserEntity user : allUsersList) {
            System.out.println(user.toString());
        }

        // Test Delete User
        userDao.deleteUserById(987);

        // Test Select by Id User
        userDao.getUserById(5);

        // Test Show all users User
        List<UserEntity> allUsersList2 = userDao.getAllUsers();
        for (UserEntity user : allUsersList2) {
            System.out.println(user.toString());
        }

        ReminderDao reminderDao = (ReminderDao) context.getBean("jdbcReminderDao");

        ReminderEntity testReminder = new ReminderEntity(7, "Life is good!", "Theme 1", 2);
        reminderDao.addReminder(testReminder);
        reminderDao.getReminderById(7);



    }
}
