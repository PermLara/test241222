package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User findByCarAttributes(String model, int series) {
        User resultUser = null;
        //String hql = "from User u where u.car.model like :model and u.car.series like :series";
        String hql = "from User u where u.privateCar.model like :model and u.privateCar.series like :series";
        //String hql = "from User u left join Car c where c.model like :model and c.series like :series";
        Query query = sessionFactory.getCurrentSession()
                .createQuery(hql)
                .setParameter("model", model)
                .setParameter("series", series)
                .setMaxResults(1);
        try {
            resultUser = (User) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("No entity found for query");
        }
        return resultUser;
    }
}
