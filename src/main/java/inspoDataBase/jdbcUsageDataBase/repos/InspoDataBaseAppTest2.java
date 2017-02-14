package inspoDataBase.jdbcUsageDataBase.repos;

import inspoDataBase.dao.ReminderDao;
import inspoDataBase.dao.UserDao;
import inspoDataBase.model.Reminder;
import inspoDataBase.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Andy on 09.02.2017.
 */
public class InspoDataBaseAppTest2 {
    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("InspoMinderDataBaseConfig.xml");
        UserDao userDao = (UserDao) context.getBean("jdbcUserDao");

        // Test Add User
        User userMarina = new User(100, "11TestMar", "333");
        userDao.addUser(userMarina);

        // Test Show all users User
        List<User> allUsersList = userDao.getAllUsers();
        for (User user : allUsersList) {
            System.out.println(user.toString());
        }

        // Test Delete User
        userDao.deleteUserById(100);

        // Test Select by Id User
        userDao.getUserById(5);

        // Test Show all users User
        List<User> allUsersList2 = userDao.getAllUsers();
        for (User user : allUsersList2) {
            System.out.println(user.toString());
        }

        ReminderDao reminderDao = (ReminderDao) context.getBean("jdbcReminderDao");

        Reminder testReminder = new Reminder(1, "Life is good!", 1, 2);
        reminderDao.addReminder(testReminder);
        reminderDao.getReminderById(1);



    }
}
