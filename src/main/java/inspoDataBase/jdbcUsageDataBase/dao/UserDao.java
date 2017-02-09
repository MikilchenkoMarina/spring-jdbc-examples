package inspoDataBase.jdbcUsageDataBase.dao;

import inspoDataBase.jdbcUsageDataBase.model.User;

/**
 * Created by mmikilchenko on 09.02.2017.
 */
public interface UserDao {
    public void addUser ( User user);
    public void getUserById();

}
