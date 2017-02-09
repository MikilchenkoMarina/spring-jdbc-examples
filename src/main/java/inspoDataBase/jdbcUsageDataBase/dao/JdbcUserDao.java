package inspoDataBase.jdbcUsageDataBase.dao;


import inspoDataBase.jdbcUsageDataBase.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.LinkedHashMap;

/**
 * Created by mmikilchenko on 09.02.2017.
 */
public class JdbcUserDao implements UserDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void addUser(User user) {
        final String SQL_INSERT_CONTACT =
                "INSERT INTO contact (USER_ID,USER_NAME,USER_PASSWORD " +
                        "VALUES(:userId,:userName,:userPassword);";

        LinkedHashMap<String, Object> params = new LinkedHashMap<String, Object>();

        params.put("userId", user.getUserId());
        params.put("userName", user.getUserName());
        params.put("userPassword", user.getUserPassword());

    }

    public void getUserById() {

    }
}
