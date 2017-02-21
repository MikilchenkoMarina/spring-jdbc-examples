package inspoDataBase.jpaUsageDataBase.app;



import inspoDataBase.entity.Reminder;
import inspoDataBase.entity.User;
import inspoDataBase.jpaUsageDataBase.JpaSpringConfigs;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by mmikilchenko on 21.02.2017.
 */
public class StandaloneJpaDbAppTest {


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JpaSpringConfigs.class);
        MainBean mainBean = (MainBean) context.getBean("mainBean");
        User testUser = new User(1, "TestUserName1", "pass", null);
        Reminder rem = new Reminder(3, "Test Jpa Reminder. ", "Test Quotes", testUser);
        mainBean.addUser(testUser);
        mainBean.addReminder(rem, testUser);


    }


}
