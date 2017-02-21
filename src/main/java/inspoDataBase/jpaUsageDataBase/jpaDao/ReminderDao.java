package inspoDataBase.jpaUsageDataBase.jpaDao;

import inspoDataBase.jpaUsageDataBase.entity.Reminder;

import java.util.List;

/**
 * Created by mmikilchenko on 09.02.2017.
 */
public interface ReminderDao {
    public void addReminder(Reminder reminder);

/*    public Reminder getReminderById(int reminderId);

    public List<Reminder> showRemindersByUserId(int userId);

    public List<Reminder> showRemindersByTheme(int themeId);

    public void deleteReminderById(int reminderId);

    public void updateReminder(Reminder reminder);*/

}
