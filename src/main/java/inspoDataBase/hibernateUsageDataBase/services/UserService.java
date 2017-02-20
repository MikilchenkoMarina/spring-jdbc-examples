package inspoDataBase.hibernateUsageDataBase.services;

import inspoDataBase.hibernateUsageDataBase.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Andy on 19.02.2017.
 */
public class UserService {
    @Autowired
    UserDao userDao ;
}
