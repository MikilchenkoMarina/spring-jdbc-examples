package inspoDataBase.jdbcUsageDataBase.dao;

import com.sun.istack.internal.Nullable;
import inspoDataBase.jdbcUsageDataBase.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by mmikilchenko on 09.02.2017.
 */
@Repository("jdbcUserDao")
public class JdbcUserDao implements UserDao {
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void addUser(User user) {
        final String SQL_ADD_USER =
                "INSERT INTO USER (USER_ID,USER_NAME,USER_PASSWORD )" +
                        "VALUES(:userId,:userName,:userPassword);";

        LinkedHashMap<String, Object> params = new LinkedHashMap<String, Object>();
        params.put("userId", user.getUserId());
        params.put("userName", user.getUserName());
        params.put("userPassword", user.getUserPassword());
        jdbcTemplate.update(SQL_ADD_USER, params);
    }

    @Override
    public User getUserById(int id) {
        final String SQL_GET_USER_BY_ID =
                "SELECT * FROM USER WHERE USER_ID = :userId ;";
        LinkedHashMap<String, Object> params = new LinkedHashMap<String, Object>();
        params.put("userId", id);

        try {
            return jdbcTemplate.queryForObject(SQL_GET_USER_BY_ID, params, this::mapUser);
        } catch (EmptyResultDataAccessException e) {
            System.out.println(String.format("User With ID %s is not existed : ", id));
            return null;
        }

    }

    @Override
    public void deleteUserById(int id) {
        final String SQL_DELETE_USER_BY_ID = "DELETE  FROM USER where USER_ID = :userId;";
        LinkedHashMap<String, Object> params = new LinkedHashMap<String, Object>();
        params.put("userId", id);
        jdbcTemplate.update(SQL_DELETE_USER_BY_ID, params);
    }

    @Override
    public List<User> getAllUsers() {
        final String SQL_GET_ALL_USERS_LIST = "SELECT * FROM USER ;";
        return jdbcTemplate.query(SQL_GET_ALL_USERS_LIST, this::mapUser);
    }

    @Nullable
    public User mapUser(ResultSet rs, int row) throws SQLException {
        return new User(
                rs.getInt("USER_ID"),
                rs.getString("USER_NAME"),
                rs.getString("USER_PASSWORD")
        );
    }


}
