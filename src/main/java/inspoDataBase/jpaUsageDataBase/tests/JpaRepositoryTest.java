package inspoDataBase.jpaUsageDataBase.tests;

import inspoDataBase.entity.Reminder;
import inspoDataBase.entity.User;
import inspoDataBase.jpaUsageDataBase.JpaSpringConfigs;
import inspoDataBase.jpaUsageDataBase.jpaRepository.ReminderRepository;
import inspoDataBase.jpaUsageDataBase.jpaRepository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

/**
 * Created by mmikilchenko on 21.02.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaSpringConfigs.class})
@Transactional
public class JpaRepositoryTest {
    @Autowired
    ReminderRepository reminderRepository;
    @Autowired
    UserRepository userRepository;
    private static Logger logger = LoggerFactory.getLogger(JpaRepositoryTest.class);

    @Test
    public void start() {

        User testUser = new User(1, "TestUserName1", "pass", null);
        userRepository.saveAndFlush(testUser);
        Reminder newReminder = new Reminder(3, "Test Jpa Reminder. ", "Test Quotes", testUser);

        reminderRepository.saveAndFlush(newReminder);
        assertNotNull(reminderRepository);
        assertNotNull(userRepository);

    }
}
