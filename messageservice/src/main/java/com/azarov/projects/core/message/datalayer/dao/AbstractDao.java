package com.azarov.projects.core.message.datalayer.dao;

/**
 * Created by AzarovD on 25.08.2016.
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Object persist(Object entity) {
        return getSession().merge(entity);
    }

    public void delete(Object entity) {
        getSession().delete(entity);
    }
}
