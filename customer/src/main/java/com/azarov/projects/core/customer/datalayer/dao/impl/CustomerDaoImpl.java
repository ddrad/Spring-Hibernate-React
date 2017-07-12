package com.azarov.projects.core.customer.datalayer.dao.impl;

/**
 * Created by AzarovD on 25.08.2016.
 */

import java.util.List;
import com.azarov.projects.core.customer.datalayer.dao.AbstractDao;
import com.azarov.projects.core.customer.datalayer.dao.CustomerDao;
import com.azarov.projects.core.customer.datalayer.entity.CustomerEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao implements CustomerDao {

    @Override
    @Transactional
    public CustomerEntity saveCustomer(CustomerEntity customerEntity) {
        return (CustomerEntity) persist(customerEntity);
    }

    @Override
    @Transactional
    public CustomerEntity findById(int id) {
        Criteria criteria = getSession().createCriteria(CustomerEntity.class);
        criteria.add(Restrictions.idEq(id));
        return (CustomerEntity) criteria.uniqueResult();
    }

    @Override
    @Transactional
    public List<CustomerEntity> findAllCustomer() {
        Criteria criteria = getSession().createCriteria(CustomerEntity.class);
        return (List<CustomerEntity>) criteria.list();
    }

    @Override
    @Transactional
    public void updateCustomer(CustomerEntity customerEntity) {
        getSession().update(customerEntity);
    }
}
