package com.azarov.projects.core.authorization.datalayer.dao.impl;

import com.azarov.projects.core.authorization.datalayer.dao.AbstractDao;
import com.azarov.projects.core.authorization.datalayer.dao.AuthorizationDao;
import com.azarov.projects.core.authorization.datalayer.entity.AuthorizationEntity;
import com.azarov.projects.core.authorization.service.Authorization;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by Dmitiy on 28.08.2016.
 */
@Repository("authorizationDao")
public class AuthorizationDaoImpl extends AbstractDao implements AuthorizationDao {

    @Override
    public AuthorizationEntity findByAuthId(int authorizationId) {
        Criteria criteria = getSession().createCriteria(AuthorizationEntity.class);
        criteria.add(Restrictions.idEq(authorizationId));
        return (AuthorizationEntity) criteria.uniqueResult();
    }

    @Override
    public AuthorizationEntity findByAuthData(String login, String password) {
        Criteria criteria = getSession().createCriteria(AuthorizationEntity.class);
        criteria.add(Restrictions.or(Restrictions.eq("login", login),
                Restrictions.eq("email", login)));
        criteria.add(Restrictions.and(Restrictions.eq("password", password)));
        return (AuthorizationEntity) criteria.uniqueResult();
    }
}
