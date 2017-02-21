package inspoDataBase.jpaUsageDataBase.jpaRepository;


import inspoDataBase.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by mmikilchenko on 09.02.2017.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User saveAndFlush(User user);

    List<User> findAll();


}
