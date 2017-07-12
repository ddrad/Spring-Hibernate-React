package com.azarov.projects.core.message.datalayer.dao.impl;

import com.azarov.projects.core.message.datalayer.dao.AbstractDao;
import com.azarov.projects.core.message.datalayer.dao.MessageDao;
import com.azarov.projects.core.message.datalayer.entity.MessageEntity;
import org.springframework.stereotype.Repository;

/**
 * Copyright DonRiver Inc. All Rights Reserved.
 *
 * @Author: Dmitry Azarov
 * @Created: 2017-06-28
 */
@Repository("messageDao")
public class MessageDaoImpl extends AbstractDao implements MessageDao {

    @Override
    public void createMessage(MessageEntity messageEntity) {
        persist(messageEntity);
    }
}
