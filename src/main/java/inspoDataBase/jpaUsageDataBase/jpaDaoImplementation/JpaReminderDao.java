package inspoDataBase.jpaUsageDataBase.jpaDaoImplementation;

import inspoDataBase.jpaUsageDataBase.entity.Reminder;
import inspoDataBase.jpaUsageDataBase.jpaDao.ReminderDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by mmikilchenko on 21.02.2017.
 */
@Repository("jpaReminderDao")
@Transactional
public class JpaReminderDao implements ReminderDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addReminder(Reminder reminder) {
        em.persist(reminder);

    }
}
