package hiber.dao;

import hiber.model.UserTest;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class UserTestDaoImp implements UserTestDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserTestDaoImp(SessionFactory sessionFactory) {
        System.out.println("из конструктора UserTestDaoImp sessionFactory ="+ sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    @Override
    public UserTest getUserTest(Long id) {
        UserTest resultUser = null;
        String hql = "from User u where u.id = :id";
        Query query = sessionFactory.getCurrentSession()
                .createQuery(hql)
                .setParameter("id", id)
                .setMaxResults(1);
        try {
            resultUser = (UserTest) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("No entity found for query id=" + id);
        }
        return resultUser;
    }

    @Override
    public void addUserTest(UserTest userTest) {
        sessionFactory.getCurrentSession().save(userTest);
        System.out.println("UserTestDaoImp сохранен " + userTest);
    }
}
