package inspoDataBase.jpaUsageDataBase.app;

import inspoDataBase.entity.Reminder;
import inspoDataBase.entity.User;
import inspoDataBase.jpaUsageDataBase.JpaSpringConfigs;
import inspoDataBase.jpaUsageDataBase.jpaRepository.ReminderRepository;
import inspoDataBase.jpaUsageDataBase.jpaRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Andy on 21.02.2017.
 */
@ContextConfiguration(classes = {JpaSpringConfigs.class})
@Transactional
public class MainBean {
    @Autowired
    ReminderRepository reminderRepository;
    @Autowired
    UserRepository userRepository;

    public void addUser(User user) {

        User testUser = new User(1, "TestUserName1", "pass", null);
        userRepository.saveAndFlush(testUser);


    }

    public void addReminder(Reminder reminder, User user) {
        Reminder newReminder = new Reminder(3, "Test Jpa Reminder. ", "Test Quotes", user);
        reminderRepository.saveAndFlush(newReminder);
    }

}
