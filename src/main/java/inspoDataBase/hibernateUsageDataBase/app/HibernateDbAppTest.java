package inspoDataBase.hibernateUsageDataBase.app;

import inspoDataBase.hibernateUsageDataBase.HibernateConfigs;
import inspoDataBase.hibernateUsageDataBase.dao.ReminderDao;
import inspoDataBase.hibernateUsageDataBase.dao.UserDao;
import inspoDataBase.hibernateUsageDataBase.entity.Reminder;
import inspoDataBase.hibernateUsageDataBase.entity.User;
import inspoDataBase.hibernateUsageDataBase.hibernateDaoImplementation.HibernateUserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mmikilchenko on 14.02.2017.
 */
public class HibernateDbAppTest {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfigs.class);
        UserDao userDao = (UserDao) context.getBean("hibernateUserDao");
        ReminderDao reminderDao = (ReminderDao) context.getBean("hibernateReminderDao");

        List<Reminder> remList = new ArrayList<>();

        Reminder reminderOne = new Reminder(1, "As our case is new, we must think and act anew. ", "Abraham Lincoln Quotes", null);
        Reminder reminderTwo = new Reminder(2, "Important principles may, and must, be inflexible. ", "First theme", null);
        remList.addAll(Arrays.asList(reminderOne, reminderTwo));

        reminderDao.addReminder(reminderOne);
        reminderDao.addReminder(reminderTwo);

        User testUser = new User(1, "TestUserName1", "pass", remList);
        userDao.addUser(testUser);

        updateRemembers(reminderDao, remList, testUser);

        printUser(userDao, 1);

        printRemindersByUserId(reminderDao, 1);

        userDao.deleteUserById(1);

        printAllExistedUsersList(userDao);

    }

    public static void printAllExistedUsersList(UserDao userDao) {
        for (User user : userDao.getAllUsers()) {
            System.out.println(user.toString());
        }
    }

    public static void printRemindersByUserId(ReminderDao reminderDao, int userId) {
        for (Reminder userReminder : reminderDao.showRemindersByUserId(userId)) {
            System.out.println(" THEME :  " + userReminder.getThemeId() + " Reminder text : " + userReminder.getReminderText());
        }
    }

    public static void printUser(UserDao userDao, int userId) {
        System.out.println(" User with id 1 : " + userDao.getUserById(1).toString());
    }

    public static void updateRemembers(ReminderDao reminderDao, List<Reminder> remList, User testUser) {
        for (Reminder reminder : remList) {
            reminder.setUser(testUser);
            reminderDao.updateReminder(reminder);
        }
    }

}
