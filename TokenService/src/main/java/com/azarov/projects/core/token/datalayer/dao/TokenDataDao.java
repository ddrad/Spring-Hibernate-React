package com.azarov.projects.core.token.datalayer.dao;

/**
 * Created by AzarovD on 24.08.2016.
 */

import com.azarov.projects.core.token.datalayer.entity.TokenDataEntity;
import com.azarov.projects.core.token.service.TokenDataStatus;

import java.util.List;
import java.util.Map;

public interface TokenDataDao {

    TokenDataEntity createTokenDataEntity(TokenDataEntity entity);

    TokenDataEntity findById(int tokenId);

    TokenDataEntity findByAlias(String alias);

    TokenDataEntity updateTokenDataEntity(TokenDataEntity entity);

    void updateTokenDataEntities(List<Integer> tokenDataIdList, TokenDataStatus tokenStatus);

    void removeTokenDataByAlias(String alias);

    void removeTokenDataById(int id);

    void removeExpiredTokenData();

}

