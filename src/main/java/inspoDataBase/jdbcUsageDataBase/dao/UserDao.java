package inspoDataBase.jdbcUsageDataBase.dao;

import inspoDataBase.jdbcUsageDataBase.entity.UserEntity;

import java.util.List;

/**
 * Created by mmikilchenko on 09.02.2017.
 */
public interface UserDao {
    public void addUser(UserEntity user);

    public UserEntity getUserById(int id);

    public void deleteUserById(int id);

    public List<UserEntity> getAllUsers();

}
