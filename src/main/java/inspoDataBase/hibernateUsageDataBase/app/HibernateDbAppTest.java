package inspoDataBase.hibernateUsageDataBase.app;

import inspoDataBase.entity.UserEntity;
import inspoDataBase.hibernateUsageDataBase.hibernateDaoImplementation.HibernateUserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by mmikilchenko on 14.02.2017.
 */
public class HibernateDbAppTest {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(inspoDataBase.hibernateUsageDataBase.HibernateConfigs.class);
        HibernateUserDao userDao = (HibernateUserDao) context.getBean("hibernateUserDao");

        UserEntity userMarina = new UserEntity(71, "TestUser", "pass");
        userDao.addUser(userMarina);

    }


}
