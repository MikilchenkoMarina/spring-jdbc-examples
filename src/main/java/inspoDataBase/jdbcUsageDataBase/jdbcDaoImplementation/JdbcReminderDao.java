package inspoDataBase.jdbcUsageDataBase.jdbcDaoImplementation;


import inspoDataBase.dao.ReminderDao;
import inspoDataBase.jdbcUsageDataBase.entity.ReminderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by mmikilchenko on 09.02.2017.
 */
@Repository("jdbcReminderDao")
public class JdbcReminderDao implements ReminderDao {
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void addReminder(ReminderEntity reminder) {
        String SQL_ADD_REMINDER =
                "INSERT INTO REMINDER (REMINDER_ID,REMINDER_TEXT,THEME_ID,USER_ID ) " +
                        "   VALUES (:reminderId,:reminderText,:themeId,:userId)";

        LinkedHashMap<String, Object> params = new LinkedHashMap<String, Object>();
        params.put("reminderId", reminder.getReminderId());
        params.put("reminderText", reminder.getReminderText());
        params.put("themeId", reminder.getThemeId());
        params.put("userId", reminder.getUserId());
        jdbcTemplate.update(SQL_ADD_REMINDER, params);

    }

    @Override
    public ReminderEntity getReminderById(int reminderId) {
        String SQL_GET_REMINDER_BY_ID = "SELECT * FROM REMINDER WHERE REMINDER_ID = :reminderId";

        HashMap<String, Object> params = new LinkedHashMap<>();
        params.put("reminderId", reminderId);
        return jdbcTemplate.queryForObject(SQL_GET_REMINDER_BY_ID, params, this::mapReminder);
    }

   // @Nullable
    public ReminderEntity mapReminder(ResultSet rs, int rowNum) throws SQLException {
        return new ReminderEntity(
                rs.getInt("REMINDER_ID"),
                rs.getString("REMINDER_TEXT"),
                rs.getString("THEME_ID"),
                rs.getInt("USER_ID")
        );
    }

    @Override
    public List<ReminderEntity> showRemindersByUserId(int userId) {
        String SQL_GET_ALL_USER_REMINDER_BY_USER_ID =
                "SELECT  * FROM REMINDER WHERE USER_ID =:userId;";
        HashMap<String, Object> param = new HashMap<>();
        param.put("userId", userId);
        return jdbcTemplate.query(SQL_GET_ALL_USER_REMINDER_BY_USER_ID, param, this::mapReminder);
    }

    @Override
    public List<ReminderEntity> showRemindersByTheme(int themeId) {
        String SQL_GET_ALL_REMINDER_BY_THEME_ID =
                "SELECT  * FROM REMINDER WHERE THEME_ID =:userId;";
        HashMap<String, Object> param = new HashMap<>();
        param.put("themeId", themeId);
        return jdbcTemplate.query(SQL_GET_ALL_REMINDER_BY_THEME_ID, param, this::mapReminder);
    }
}
