package com.azarov.projects.websocket.controller;

import com.azarov.projects.core.authorization.service.Authorization;
import com.azarov.projects.core.authorization.service.AuthorizationService;
import com.azarov.projects.core.customer.service.Customer;
import com.azarov.projects.core.customer.service.CustomerService;
import com.azarov.projects.core.token.service.TokenData;
import com.azarov.projects.core.token.service.TokenService;
import com.azarov.projects.websocket.vo.data.AliasData;
import com.azarov.projects.websocket.vo.data.DataError;
import com.azarov.projects.websocket.vo.data.ErrorCode;
import com.azarov.projects.websocket.vo.data.LoginData;
import com.azarov.projects.websocket.vo.tokenmessage.TokenMessageRequest;
import com.azarov.projects.websocket.vo.tokenmessage.TokenMessageResponse;
import com.azarov.projects.websocket.vo.tokenmessage.TokenMessageType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.UUID;

/**
 * Copyright DonRiver Inc. All Rights Reserved.
 *
 * @Author: Dmitry Azarov
 * @Created: 2017-07-04
 */

@Controller
public class WebContcroller {

    @Autowired
    @Qualifier("authorizationService")
    private AuthorizationService authorizationService;

    @Autowired
    @Qualifier("tokenService")
    private TokenService tokenService;

    @Autowired
    @Qualifier("customerService")
    private CustomerService customerService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public String login(@RequestBody TokenMessageRequest loginRequest) throws JsonProcessingException {

        LoginData loginData = (LoginData) loginRequest.getData();
        Authorization authorizationInfo = getAuthorizationInfo(loginData.getLogin(), loginData.getPassword());
        if (authorizationInfo == null) {
            return new ObjectMapper().writeValueAsString(buildFailedAuthorizationResponse());
        }

        DateTime expirationTime = DateTime.now().plusMinutes(30);
        TokenData tokenData = generateToken(authorizationInfo, expirationTime);

        return new ObjectMapper().writeValueAsString(buildDataSuccess(tokenData));
    }

    private Authorization getAuthorizationInfo(String login, String password) {
        return authorizationService.findByAuthData(login, password);
    }

    private TokenData generateToken(Object data, DateTime expirationTime) {
        return tokenService.generateToken(UUID.randomUUID().toString(), data, expirationTime, false);
    }

    private TokenMessageResponse buildFailedAuthorizationResponse() {
        TokenMessageResponse response = new TokenMessageResponse();
        response.setType(TokenMessageType.CUSTOMER_ERROR.name());
        DataError error = new DataError();
        error.setErrorCode(ErrorCode.CUSTOMER_NOT_FOUND);
        error.setErrorDescription(ErrorCode.CUSTOMER_NOT_FOUND.toString());
        response.setData(error);
        return response;
    }

    private TokenMessageResponse buildDataSuccess(TokenData tokenData) {
        TokenMessageResponse response = new TokenMessageResponse();
        response.setType(TokenMessageType.CUSTOMER_API_TOKEN.name());
        AliasData data = new AliasData();
        data.setTokenAlias(tokenData.getAlias());
        response.setData(data);
        return response;
    }
}
