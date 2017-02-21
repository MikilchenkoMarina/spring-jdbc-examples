package inspoDataBase.jpaUsageDataBase.jpaRepository;


import inspoDataBase.entity.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by mmikilchenko on 09.02.2017.
 */
public interface ReminderRepository extends JpaRepository<Reminder, Integer> {
   Reminder saveAndFlush(Reminder reminder);
   List<Reminder> findAll();
  // Reminder findByReminderId(int reminderId);


}
