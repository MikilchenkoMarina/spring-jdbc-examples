package inspoDataBase.jpaUsageDataBase.jpaRepository;


import inspoDataBase.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by mmikilchenko on 09.02.2017.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    // Demonstrate query creation by method name
    // http://static.springsource.org/spring-data/data-jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    User saveAndFlush(User user);

    List<User> findAll();

    // Demonstrate the use of a simple JPQL query
    @Query("from User u where upper(u.user_name) = upper(:userName)")
    User findByNameIgnoreCase(@Param("userName") String userName);


}
