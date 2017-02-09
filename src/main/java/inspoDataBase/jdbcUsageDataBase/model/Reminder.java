package inspoDataBase.jdbcUsageDataBase.model;

/**
 * Created by mmikilchenko on 09.02.2017.
 */
public class Reminder {
    public int getReminderId() {
        return reminderId;
    }

    public void setReminderId(int reminderId) {
        this.reminderId = reminderId;
    }

    public String getReminderText() {
        return reminderText;
    }

    public void setReminderText(String reminderText) {
        this.reminderText = reminderText;
    }

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int reminderId;
    public String reminderText;
    public int themeId;
    public int userId;

    @Override
    public String toString() {
        return "Reminder{" +
                "reminderId=" + reminderId +
                ", reminderText='" + reminderText + '\'' +
                ", themeId=" + themeId +
                ", userId=" + userId +
                '}';
    }
}
