//package com.azarov.projects.websocket.controller;
//
//import com.azarov.projects.core.address.service.AddressInfoService;
//import com.azarov.projects.core.authorization.service.AuthorizationService;
//import com.azarov.projects.core.authorization.service.Authorization;
//import com.azarov.projects.core.business.customer.service.BusinessCustomer;
//import com.azarov.projects.core.business.customer.service.BusinessCustomerStatus;
//import com.azarov.projects.core.business.customer.service.BusinessCustomerType;
//import com.azarov.projects.core.customer.service.Customer;
//import com.azarov.projects.core.customer.service.CustomerService;
//import com.azarov.projects.core.message.service.Message;
//import com.azarov.projects.core.message.service.MessageSenderService;
//import com.azarov.projects.core.token.service.TokenData;
//import com.azarov.projects.core.token.service.TokenService;
//import com.azarov.projects.websocket.vo.data.*;
//import com.azarov.projects.websocket.vo.request.*;
//import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
//import org.joda.time.DateTime;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.RequestMapping;
//
///**
// * Created by AzarovD on 23.08.2016.
// */
//
//@Controller
//public class WebSocketController {
//    @Autowired
//    @Qualifier("customerService")
//    private CustomerService customerService;
//    @Autowired
//    @Qualifier("addressInfoService")
//    private AddressInfoService addressInfoService;
//    @Autowired
//    @Qualifier("authorizationService")
//    private AuthorizationService authorizationService;
//    @Autowired
//    @Qualifier("tokenService")
//    private TokenService tokenService;
//    @Autowired
//    @Qualifier("messageSenderService")
//    private MessageSenderService messageSenderService;
//
//    @MessageMapping("/auth")
//    @SendTo("/topic/showResult")
//    public TokenMessageResponse auth(TokenMessageRequest tokenMessage) throws Exception {
//        TokenMessageResponse response = new TokenMessageResponse();
//        response.setSequenceId(tokenMessage.getSequenceId());
//        DataRequest dataRequest = tokenMessage.getData();
//        Authorization authorizationInfo = getAuthorizationInfo(dataRequest.getLogin(), dataRequest.getPassword());
//        if (authorizationInfo == null) {
//            return buildFailedAuthorizationResponse(response);
//        }
//        DateTime expirationTime = DateTime.now().plusMinutes(30);
//        TokenData tokenData = generateToken(tokenMessage.getSequenceId(), authorizationInfo, expirationTime);
//        return buildDataSuccess(response, tokenData);
//    }
//
//
//    @MessageMapping("/sendMessage")
//    @SendTo("/topic/showResult")
//    public TokenMessageResponse auth(TokenSendMessageRequest request) throws Exception {
//
//        String senderToken = request.getSequenceId();
//
//        TokenMessageResponse response = new TokenMessageResponse();
//        response.setSequenceId(senderToken);
//
//        SendMessageRequest sendMessageRequest = request.getData();
//        Message message = new Message();
//        message.setSender(sendMessageRequest.getSender());
//        message.setRecipient(sendMessageRequest.getRecipient());
//        message.setTokenAlias(sendMessageRequest.getMsgTokenAlias());
//        message.setContent(Base64.decode(sendMessageRequest.getContent()));
//        try {
//            messageSenderService.send(message, senderToken);
//        }catch (Exception e){
//            return buildFailedSendMessageResponse(response);
//        }
//
//        return buildSendMessageSuccess(response);
//    }
//
//
//    @MessageMapping("/create")
//    @SendTo("/topic/showResult")
//    public TokenMessageResponse createCustomer(TokenMessageCreateCustomerRequest tokenMessage) throws Exception {
//        TokenMessageResponse response = new TokenMessageResponse();
//        response.setSequenceId(tokenMessage.getSequenceId());
//        DataCreateCustomerRequest dataRequest = tokenMessage.getData();
//        Customer customer = new Customer();
//        customer.setFirstName(dataRequest.getFirstName());
//        customer.setLastName(dataRequest.getLastName());
//        customer.setMiddleName(dataRequest.getMiddleName());
//        BusinessCustomer businessCustomer = new BusinessCustomer();
//        businessCustomer.setStatus(BusinessCustomerStatus.NEW);
//        businessCustomer.setType(BusinessCustomerType.DEFAULT);
//        customer.setBusinessCustomer(businessCustomer);
//        Authorization authorizationInfo = new Authorization();
//        authorizationInfo.setLogin(dataRequest.getLogin());
//        authorizationInfo.setPassword(dataRequest.getPassword());
//        customer.setAuthorizationInfo(authorizationInfo);
//        Customer createdCustomer = customerService.saveCustomer(customer);
//        if(createdCustomer == null){
//            buildFailedCreateCustomerResponse(response);
//        }
//        return buildCreateCustomerSuccess(response);
//    }
//
//    @Transactional
//    Authorization getAuthorizationInfo(String login, String password) {
//        return authorizationService.findByAuthData(login, password);
//    }
//
//    @Transactional
//    private TokenData generateToken(String sequenceId, Authorization authInfo, DateTime expirationTime) {
//        return tokenService.generateToken(sequenceId, authInfo, expirationTime, false);
//    }
//
//    private TokenMessageResponse buildDataSuccess(TokenMessageResponse response, TokenData tokenData) {
//        response.setType(TokenMessageType.CUSTOMER_API_TOKEN.name());
//        DataSuccess dataSuccess = new DataSuccess();
//        dataSuccess.setApiToken(tokenData.getAlias());
//        dataSuccess.setApiTokenExpirationDate(tokenData.getExpirationTime().toString());
//        response.setData(dataSuccess);
//        return response;
//    }
//
//    private TokenMessageResponse buildCreateCustomerSuccess(TokenMessageResponse response) {
//        response.setType(TokenMessageType.NEW_CUSTOMER.name());
//        return response;
//    }
//
//    private TokenMessageResponse buildSendMessageSuccess(TokenMessageResponse response) {
//        response.setType(TokenMessageType.SEND_MESSAGE_SUCCESS.name());
//        return response;
//    }
//
//    private TokenMessageResponse buildFailedAuthorizationResponse(TokenMessageResponse response) {
//        response.setType(TokenMessageType.CUSTOMER_ERROR.name());
//        DataError error = new DataError();
//        error.setErrorCode(ErrorCode.CUSTOMER_NOT_FOUND);
//        error.setErrorDescription(ErrorCode.CUSTOMER_NOT_FOUND.toString());
//        response.setData(error);
//        return response;
//    }
//
//    private TokenMessageResponse buildFailedCreateCustomerResponse(TokenMessageResponse response) {
//        response.setType(TokenMessageType.CUSTOMER_ERROR.name());
//        DataError error = new DataError();
//        error.setErrorCode(ErrorCode.CUSTOMER_NOT_CREATED);
//        error.setErrorDescription(ErrorCode.CUSTOMER_NOT_CREATED.toString());
//        response.setData(error);
//        return response;
//    }
//
//    private TokenMessageResponse buildFailedSendMessageResponse(TokenMessageResponse response) {
//        response.setType(TokenMessageType.SEND_MESSAGE_ERROR.name());
//        DataError error = new DataError();
//        error.setErrorCode(ErrorCode.MESSAGE_WAS_NOT_SPENT);
//        error.setErrorDescription(ErrorCode.MESSAGE_WAS_NOT_SPENT.toString());
//        response.setData(error);
//        return response;
//    }
//
//    @RequestMapping("/start")
//    public String start() {
//        return "start";
//    }
//}
