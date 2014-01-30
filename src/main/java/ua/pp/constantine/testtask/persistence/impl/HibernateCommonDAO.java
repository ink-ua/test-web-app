package ua.pp.constantine.testtask.persistence.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import ua.pp.constantine.testtask.persistence.api.CommonDAO;

public abstract class HibernateCommonDAO<T> implements CommonDAO<T> {

    private SessionFactory sessionFactory;

    public HibernateCommonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public T save(T object) {
        getSession().saveOrUpdate(object);
        getSession().flush();
        return object;
    }

    public void delete(T object) {
        getSession().delete(object);
    }

    @SuppressWarnings("unchecked")
    public T findByPrimaryKey(Class<T> clazz, Long id) {
        Criteria criteria = getSession().createCriteria(clazz);
        criteria.add(Restrictions.idEq(id));
        return (T) criteria.uniqueResult();
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
