package inspoDataBase.hibernateUsageDataBase.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;


/**
 * Created by mmikilchenko on 15.02.2017.
 */
@Entity
@Table(name = "user"/*, schema = "inspominder", catalog = ""*/)
public class User {

    @Id
    @Column(name = "USER_ID", nullable = false)
    private int userId;

    @Basic
    @Column(name = "USER_NAME", nullable = true, length = 45)
    private String userName;

    @Basic
    @Column(name = "USER_PASSWORD", nullable = true, length = 45)
    private String userPassword;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true)
    @ElementCollection(targetClass = Reminder.class)
    private List<Reminder> reminders;

    public User() {
    }

    public User(int userId, String userName, String userPassword, List<Reminder> reminders) {
        this.userId = userId;
        this.reminders = reminders;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public List<Reminder> getReminders() {
        return this.reminders;
    }

    public void setReminder(List<Reminder> reminders) {
        this.reminders = reminders;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", reminders=" + reminders +
                '}';
    }
}
