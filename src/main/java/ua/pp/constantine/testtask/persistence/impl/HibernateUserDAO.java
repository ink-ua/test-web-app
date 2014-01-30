package ua.pp.constantine.testtask.persistence.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.pp.constantine.testtask.persistence.api.UserDAO;
import ua.pp.constantine.testtask.persistence.model.User;

@Repository
public class HibernateUserDAO extends HibernateCommonDAO<User> implements UserDAO {

    @Autowired
    public HibernateUserDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

	public User findByUsername(String username) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		return (User)criteria.uniqueResult();
	}

}
