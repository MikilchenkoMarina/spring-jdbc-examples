package inspoDataBase.jdbcUsageDataBase.dao;

import inspoDataBase.jdbcUsageDataBase.entity.ReminderEntity;

import java.util.List;

/**
 * Created by mmikilchenko on 09.02.2017.
 */
public interface ReminderDao {
    public void addReminder(ReminderEntity reminder);
    public ReminderEntity getReminderById(int reminderId);
    public List<ReminderEntity> showRemindersByUserId(int userId);
    public List<ReminderEntity> showRemindersByTheme(int themeId);

}
