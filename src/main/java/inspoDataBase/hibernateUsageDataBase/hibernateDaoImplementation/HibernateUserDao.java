package inspoDataBase.hibernateUsageDataBase.hibernateDaoImplementation;

import inspoDataBase.hibernateUsageDataBase.dao.UserDao;
import inspoDataBase.hibernateUsageDataBase.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mmikilchenko on 14.02.2017.
 */
@Repository("hibernateUserDao")
public class HibernateUserDao implements UserDao {
    private SessionFactory sessionFactory;

    @Autowired
    public HibernateUserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        try {
            return sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            return sessionFactory.openSession();
        }
    }

    @Override
    @Transactional
    public void addUser(User user) {
        Session session = currentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public void deleteUserById(int id) {
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
