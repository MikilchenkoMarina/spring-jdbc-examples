package inspoDataBase.jdbcUsageDataBase.entity;

import javax.persistence.*;

/**
 * Created by mmikilchenko on 15.02.2017.
 */
public class ReminderEntity {
    private int reminderId;
    private String reminderText;
    private String  themeId;
    public int userId;

    public ReminderEntity(int reminderId, String reminderText, String themeId,int userId) {
        this.reminderId = reminderId;
        this.reminderText = reminderText;
        this.themeId = themeId;
        this.userId = userId;
     }

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

    public String getThemeId() {
        return themeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setThemeId(String themeId) {
        this.themeId = themeId;
    }

}
