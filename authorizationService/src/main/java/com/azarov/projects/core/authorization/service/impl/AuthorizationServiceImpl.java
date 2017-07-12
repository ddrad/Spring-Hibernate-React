package com.azarov.projects.core.authorization.service.impl;

import com.azarov.projects.core.authorization.datalayer.dao.AuthorizationDao;
import com.azarov.projects.core.authorization.datalayer.entity.AuthorizationEntity;
import com.azarov.projects.core.authorization.service.AuthorizationService;
import com.azarov.projects.core.authorization.service.Authorization;
import com.azarov.projects.core.authorization.service.convert.AuthorizationConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * Created by Dmitiy on 27.08.2016.
 */

@Service("authorizationService")
public class AuthorizationServiceImpl implements AuthorizationService {
    @Autowired
    @Qualifier("authorizationDao")
    private AuthorizationDao dao;
    @Autowired
    @Qualifier("authorizationConvert")
    private AuthorizationConvert convert;

    @Override
    @Transactional
    public Authorization findByAuthID(String authorizationId) {
        if (StringUtils.isEmpty(authorizationId)) {
            return null;
        }

        int parseInt = Integer.parseInt(authorizationId);

        AuthorizationEntity authorizationEntity = dao.findByAuthId(parseInt);
        if (authorizationEntity == null) {
            return null;
        }
        return convert.toAuthorization(authorizationEntity);
    }

    @Override
    @Transactional
    public Authorization findByAuthData(String login, String password) {
        if (StringUtils.isEmpty(login) || StringUtils.isEmpty(password)) {
            return null;
        }
        AuthorizationEntity authorizationEntity = dao.findByAuthData(login, password);
        if (authorizationEntity == null) {
            return null;
        }
        return convert.toAuthorization(authorizationEntity);
    }
}
