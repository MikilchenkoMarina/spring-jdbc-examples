package inspoDataBase.entity;

import javax.persistence.*;

/**
 * Created by mmikilchenko on 15.02.2017.
 */
@Entity
@Table(name = "reminder", schema = "inspominder", catalog = "")
public class ReminderEntity {
    private int reminderId;
    private String reminderText;
    private String  themeId;
    public int userId;
   /* private UserEntity userEntity;

    // Relation to User
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    public UserEntity getUserEntity() {
        return this.userEntity;
    }*/

    public ReminderEntity(int reminderId, String reminderText, String themeId,int userId) {
        this.reminderId = reminderId;
        this.reminderText = reminderText;
        this.themeId = themeId;
        this.userId = userId;
    }

    @Id
    @Column(name = "REMINDER_ID", nullable = false)
    public int getReminderId() {
        return reminderId;
    }

    public void setReminderId(int reminderId) {
        this.reminderId = reminderId;
    }

    @Basic
    @Column(name = "REMINDER_TEXT", nullable = true, length = 45)
    public String getReminderText() {
        return reminderText;
    }

    public void setReminderText(String reminderText) {
        this.reminderText = reminderText;
    }

    @Basic
    @Column(name = "THEME_ID", nullable = true, length = 45)
    public String getThemeId() {
        return themeId;
    }

    @Basic
    @Column(name = "USER_ID", nullable = true)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setThemeId(String themeId) {
        this.themeId = themeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReminderEntity that = (ReminderEntity) o;

        if (reminderId != that.reminderId) return false;
        if (reminderText != null ? !reminderText.equals(that.reminderText) : that.reminderText != null) return false;
        if (themeId != null ? !themeId.equals(that.themeId) : that.themeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reminderId;
        result = 31 * result + (reminderText != null ? reminderText.hashCode() : 0);
        result = 31 * result + (themeId != null ? themeId.hashCode() : 0);
        return result;
    }
}
