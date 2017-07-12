package com.azarov.projects.core.authorization.datalayer.dao;

import com.azarov.projects.core.authorization.datalayer.entity.AuthorizationEntity;

/**
 * Created by Dmitiy on 27.08.2016.
 */
public interface AuthorizationDao {

    AuthorizationEntity findByAuthId(int authorizationId);

    AuthorizationEntity findByAuthData(String login, String password);
}
