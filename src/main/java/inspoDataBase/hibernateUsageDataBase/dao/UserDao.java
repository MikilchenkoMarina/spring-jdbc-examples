package inspoDataBase.hibernateUsageDataBase.dao;

import inspoDataBase.hibernateUsageDataBase.entity.User;

import java.util.List;

/**
 * Created by mmikilchenko on 09.02.2017.
 */
public interface UserDao {
    public void addUser(User user);

    public User getUserById(int id);

    public boolean deleteUserById(int id);

    public List<User> getAllUsers();

}
