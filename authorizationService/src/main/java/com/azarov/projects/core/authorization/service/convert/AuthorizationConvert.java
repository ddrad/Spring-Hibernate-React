package com.azarov.projects.core.authorization.service.convert;

import com.azarov.projects.core.authorization.datalayer.entity.AuthorizationEntity;
import com.azarov.projects.core.authorization.service.Authorization;
import org.springframework.stereotype.Service;

/**
 * Created by AzarovD on 25.08.2016.
 */

@Service("authorizationConvert")
public class AuthorizationConvert {

    public Authorization toAuthorization(AuthorizationEntity authorizationEntity) {
        Authorization authorizationInfo = new Authorization();
        authorizationInfo.setLogin(authorizationEntity.getLogin());
        authorizationInfo.setPassword(authorizationEntity.getPassword());
        authorizationInfo.setCustomerId(authorizationEntity.getCustomerId());
        return authorizationInfo;
    }

    public AuthorizationEntity toAuthorizationEntity(Authorization authorization) {
        AuthorizationEntity entity = new AuthorizationEntity();
        entity.setLogin(authorization.getLogin());
        entity.setPassword(authorization.getPassword());
        entity.setCustomerId(authorization.getCustomerId());
        return entity;
    }
}
