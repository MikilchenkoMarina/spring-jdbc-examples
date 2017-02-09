package inspoDataBase.jdbcUsageDataBase.dao;

import inspoDataBase.jdbcUsageDataBase.model.User;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


import javax.sql.DataSource;
import java.util.LinkedHashMap;

/**
 * Created by mmikilchenko on 09.02.2017.
 */
public class JdbcUserDao implements UserDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void addUser(User user) {
        final String SQL_ADD_USER =
                "INSERT INTO USER (USER_ID,USER_NAME,USER_PASSWORD )" +
                        "VALUES(:userId,:userName,:userPassword);";

        LinkedHashMap<String, Object> params = new LinkedHashMap<String, Object>();

        params.put("userId", user.getUserId());
        params.put("userName", user.getUserName());
        params.put("userPassword", user.getUserPassword());

        jdbcTemplate.update(SQL_ADD_USER, params);
        //SqlQueryHelper helper = new SqlQueryHelper();
        //String parametrizedQuery = helper.getSqlQueryWithBindParams(dataSource, SQL_ADD_USER, params);


    }

    public void getUserById() {

    }
}
