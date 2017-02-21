package inspoDataBase.jpaUsageDataBase.app;


import inspoDataBase.jpaUsageDataBase.entity.Reminder;
import inspoDataBase.jpaUsageDataBase.jpaDao.ReminderDao;
import inspoDataBase.jpaUsageDataBase.JpaSpringConfigs;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Andy on 21.02.2017.
 */
public class JpaDbAppTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(JpaSpringConfigs.class);
    ReminderDao reminderDao = (ReminderDao) context.getBean("jpaReminderDao");




    Reminder rem = new Reminder(3, "Test Jpa Reminder. ", "Test Quotes", null);



}
