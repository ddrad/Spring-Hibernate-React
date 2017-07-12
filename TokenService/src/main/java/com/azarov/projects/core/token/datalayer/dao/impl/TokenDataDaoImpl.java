package com.azarov.projects.core.token.datalayer.dao.impl;

import com.azarov.projects.core.token.datalayer.dao.AbstractDao;
import com.azarov.projects.core.token.datalayer.dao.TokenDataDao;
import com.azarov.projects.core.token.datalayer.entity.TokenDataEntity;
import com.azarov.projects.core.token.service.TokenDataStatus;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by Dmitiy on 24.08.2016.
 */
@Repository("tokenDataDao")
public class TokenDataDaoImpl extends AbstractDao implements TokenDataDao {
    public TokenDataEntity createTokenDataEntity(TokenDataEntity entity) {
        return (TokenDataEntity) persist(entity);
    }

    @Override
    @Transactional
    public TokenDataEntity findById(int tokenId) {
        Criteria criteria = getSession().createCriteria(TokenDataEntity.class);
        criteria.add(Restrictions.eq("id", tokenId));
        return (TokenDataEntity) criteria.uniqueResult();
    }

    @Override
    @Transactional
    public TokenDataEntity findByAlias(String alias) {
        Criteria criteria = getSession().createCriteria(TokenDataEntity.class);
        criteria.add(Restrictions.eq("alias", alias));
        return (TokenDataEntity) criteria.uniqueResult();
    }

    @Override
    @Transactional
    public TokenDataEntity updateTokenDataEntity(TokenDataEntity entity) {
        return (TokenDataEntity) persist(entity);
    }

    @Override
    @Transactional
    public void updateTokenDataEntities(List<Integer> tokenDataIdList, TokenDataStatus tokenStatus) {
        Criteria criteria = getSession().createCriteria(TokenDataEntity.class)
                .add(Restrictions.in("id", tokenDataIdList));
        List<TokenDataEntity> tokenDataEntities = criteria.list();
        for (TokenDataEntity tokenDataEntity : tokenDataEntities) {
            tokenDataEntity.setStatus(tokenStatus);
            persist(tokenDataEntity);
        }
    }

    @Override
    @Transactional
    public void removeTokenDataByAlias(String alias) {
        Criteria criteria = getSession().createCriteria(TokenDataEntity.class);
        criteria.add(Restrictions.eq("alias", alias));
        TokenDataEntity entity = (TokenDataEntity) criteria.uniqueResult();
        delete(entity);
    }

    @Override
    @Transactional
    public void removeTokenDataById(int id) {
        Criteria criteria = getSession().createCriteria(TokenDataEntity.class);
        criteria.add(Restrictions.eq("id", id));
        TokenDataEntity entity = (TokenDataEntity) criteria.uniqueResult();
        delete(entity);
    }

    @Override
    @Transactional
    public void removeExpiredTokenData() {
        Criteria criteria = getSession().createCriteria(TokenDataEntity.class);
        criteria.add(Restrictions.le("expirationTime", new Date()));
        criteria.add(Restrictions.eq("removeAfterExpiration", "true"));
        List<TokenDataEntity> entities = criteria.list();
        for (TokenDataEntity entity : entities) {
            delete(entity);
        }
    }
}
