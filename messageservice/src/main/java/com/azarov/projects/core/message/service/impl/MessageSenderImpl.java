package com.azarov.projects.core.message.service.impl;

import com.azarov.projects.core.message.datalayer.dao.MessageDao;
import com.azarov.projects.core.message.datalayer.entity.MessageEntity;
import com.azarov.projects.core.message.datalayer.entity.MessagePK;
import com.azarov.projects.core.message.service.Message;
import com.azarov.projects.core.message.service.MessageSenderService;
import com.azarov.projects.core.token.service.TokenData;
import com.azarov.projects.core.token.service.TokenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Copyright DonRiver Inc. All Rights Reserved.
 *
 * @Author: Dmitry Azarov
 * @Created: 2017-06-28
 */
@Service("messageSenderService")
public class MessageSenderImpl implements MessageSenderService {

    @Autowired
    @Qualifier("tokenService")
    private TokenService tokenService;
    @Autowired
    @Qualifier("messageDao")
    private MessageDao messageDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void send(Message message, String tokenAlias) {

        if (message.getRecipient() == 0) {
            throw new IllegalArgumentException("Recipient is empty");
        }
        if (message.getSender() == 0) {
            throw new IllegalArgumentException("Sender is empty");
        }

        TokenData tokenData = tokenService.findByAlias(tokenAlias);

        if (tokenService.isExpiredTokenData(tokenData)) {
            throw new IllegalArgumentException("Token is expired");
        }

        MessageEntity entity = new MessageEntity();
        MessagePK id = new MessagePK();
        id.setSenderToken(tokenAlias);
        id.setMessageTokken(message.getTokenAlias());
        entity.setId(id);
        entity.setSender(message.getSender());
        entity.setRecipient(message.getRecipient());
        entity.setContent(message.getContent());
        messageDao.createMessage(entity);
    }
}
