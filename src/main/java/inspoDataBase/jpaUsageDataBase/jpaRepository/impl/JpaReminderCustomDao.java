package inspoDataBase.jpaUsageDataBase.jpaRepository.impl;


import inspoDataBase.entity.Reminder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by mmikilchenko on 21.02.2017.
 */
@Repository("jpaReminderDaoCustom")
@Transactional
public class JpaReminderCustomDao/* implements ReminderRepository */{

    @PersistenceContext
    private EntityManager em;

    //@Override
    public void addReminder(Reminder reminder) {
         em.persist(reminder);
    }
}
