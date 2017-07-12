package com.azarov.projects.core.token.service.impl;

import com.azarov.projects.core.token.datalayer.dao.TokenDataDao;
import com.azarov.projects.core.token.datalayer.entity.TokenDataEntity;
import com.azarov.projects.core.token.service.TokenData;
import com.azarov.projects.core.token.service.TokenDataStatus;
import com.azarov.projects.core.token.service.TokenService;
import com.azarov.projects.core.token.service.convert.TokenDataConverter;
import com.azarov.projects.core.token.service.error.Error;
import com.azarov.projects.core.token.service.util.KryoSerializer;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by AzarovD on 24.08.2016.
 */

@Service("tokenService")
public class TokenServiceImpl implements TokenService {

    @Autowired
    @Qualifier("tokenDataDao")
    private TokenDataDao tokenDataDao;
    @Autowired
    @Qualifier("tokenDataConverter")
    private TokenDataConverter tokenDataConverter;
    @Autowired
    @Qualifier("kryoSerializer")
    private KryoSerializer serializer;

    @Override
    @Transactional
    public TokenData generateToken(String alias, Object data, DateTime dt, boolean removeAfterExpiration) {
        if (StringUtils.isEmpty(alias)) {
            throw new RuntimeException(Error.ALIAS_IS_NULL.name());
        }
        TokenDataEntity tokenDataEntity = tokenDataDao.findByAlias(alias);

        if (tokenDataEntity != null) {
            TokenDataEntity entity =
                    tokenDataDao.updateTokenDataEntity(updateParamsAndExpirationTime(tokenDataEntity, data, dt));
            return tokenDataConverter.convertFromEntity(entity);
        } else {
            TokenDataEntity entity = tokenDataDao
                    .createTokenDataEntity(createTokenDataEntity(alias, data, dt, removeAfterExpiration));
            return tokenDataConverter.convertFromEntity(entity);
        }
    }

    private TokenDataEntity createTokenDataEntity(String alias, Object data, DateTime dt, boolean removeAfterExpiration) {
        TokenData tokenData = new TokenData();
        tokenData.setAlias(alias);
        tokenData.setData(data);
        tokenData.setExpirationTime(dt);
        tokenData.setStatus(TokenDataStatus.ACTIVE);
        tokenData.setRemoveAfterExpiration(removeAfterExpiration);
        return tokenDataConverter.convertToEntity(tokenData);
    }

    private TokenDataEntity updateParamsAndExpirationTime(TokenDataEntity entity, Object data, DateTime dt) {
        entity.setExpirationTime(dt.toDate());
        entity.setData(serializer.serialize(data));
        return entity;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public TokenData getTokenDataById(int tokenId) {
        TokenDataEntity entity = tokenDataDao.findById(tokenId);
        if (entity == null) {
            throw new RuntimeException(Error.TOKEN_DATA_IS_NOT_FOUND.name());
        }
        return tokenDataConverter.convertFromEntity(entity);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public TokenData findByAlias(String alias) {
        TokenDataEntity tokenDataEntity = tokenDataDao.findByAlias(alias);
        if (tokenDataEntity == null) {
            return null;
        }
        return tokenDataConverter.convertFromEntity(tokenDataEntity);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeByAlias(String alias) {
        if (StringUtils.isEmpty(alias)) {
            return;
        }
        tokenDataDao.removeTokenDataByAlias(alias);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeById(int id) {
        if (StringUtils.isEmpty(id)) {
            return;
        }
        tokenDataDao.removeTokenDataById(id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeExpiredTokenData() {
        tokenDataDao.removeExpiredTokenData();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void updateTokenStatus(List<Integer> tokenIds, TokenDataStatus tokenStatus) {
        if (tokenIds.isEmpty()) {
            return;
        }
        tokenDataDao.updateTokenDataEntities(tokenIds, tokenStatus);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void updateToken(TokenData tokenData) {
        TokenDataEntity entity = tokenDataDao.findById(tokenData.getTokenId());
        if (entity == null) {
            throw new RuntimeException(Error.TOKEN_DATA_IS_NOT_FOUND.name());
        }
        tokenDataConverter.mergeTokenEntity(entity, tokenData);
        tokenDataDao.updateTokenDataEntity(entity);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public boolean isExpiredTokenData(TokenData tokenData) {
        DateTime expirationTime = tokenData.getExpirationTime();
        return expirationTime.isBeforeNow();
    }
}
