package com.azarov.projects.core.token.datalayer.dao;

/**
 * Created by AzarovD on 24.08.2016.
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

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
