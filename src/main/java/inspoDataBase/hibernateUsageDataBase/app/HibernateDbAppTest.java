package inspoDataBase.hibernateUsageDataBase.app;

import inspoDataBase.hibernateUsageDataBase.HibernateConfigs;
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
        HibernateUserDao userDao = (HibernateUserDao) context.getBean("hibernateUserDao");



        List<Reminder> remList = new ArrayList<>();
         Reminder rem = new Reminder(398,"dfgd","dfg",null);
         remList.add(rem);

        User userMarina = new User(798,"test555","pass",remList);

        userDao.addUser(userMarina);

    }


}
