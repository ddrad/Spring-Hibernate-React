package com.azarov.projects.core.authorization.service;

/**
 * Created by Dmitiy on 27.08.2016.
 */
public interface AuthorizationService {

    Authorization findByAuthID(String authorizationId);

    Authorization findByAuthData(String login, String password);
}
