package inspoDataBase.hibernateUsageDataBase.app;

import inspoDataBase.hibernateUsageDataBase.HibernateConfigs;
import inspoDataBase.hibernateUsageDataBase.dao.UserDao;
import inspoDataBase.hibernateUsageDataBase.entity.Reminder;
import inspoDataBase.hibernateUsageDataBase.entity.User;
import inspoDataBase.hibernateUsageDataBase.hibernateDaoImplementation.HibernateUserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mmikilchenko on 14.02.2017.
 */
public class HibernateDbAppTest {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfigs.class);
        UserDao userDao = (UserDao) context.getBean("hibernateUserDao");


        List<Reminder> remList = new ArrayList<>();
        User user1 = new User(1, "TestUserName1", "pass", remList);
        Reminder rem = new Reminder(1, "Life is good", "First theme", null);
        remList.add(rem);


        userDao.addUser(user1);

        System.out.println(" User with id 1 : " + userDao.getUserById(1).toString());

        userDao.deleteUserById(1);

       for(User user : userDao.getAllUsers()){
           System.out.println(user.toString());

       }

    }

}
