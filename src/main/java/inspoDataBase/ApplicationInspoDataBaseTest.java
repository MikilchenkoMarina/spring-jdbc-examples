package inspoDataBase;

import inspoDataBase.jdbcUsageDataBase.dao.UserDao;
import inspoDataBase.jdbcUsageDataBase.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class ApplicationInspoDataBaseTest {
    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("InspoMinderDataBaseConfig.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");

        User userMarina = new User(3, "TestMar", "333");
        userDao.addUser(userMarina);


    }
}
