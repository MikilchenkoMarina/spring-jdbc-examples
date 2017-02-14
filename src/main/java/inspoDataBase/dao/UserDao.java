package inspoDataBase.dao;

import inspoDataBase.model.User;

import java.util.List;

/**
 * Created by mmikilchenko on 09.02.2017.
 */
public interface UserDao {
    public void addUser(User user);

    public User getUserById(int id);

    public void deleteUserById(int id);

    public List<User> getAllUsers();

}
