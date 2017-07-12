package com.azarov.projects.core.message.datalayer.dao;

import com.azarov.projects.core.message.datalayer.entity.MessageEntity;

/**
 * Copyright DonRiver Inc. All Rights Reserved.
 *
 * @Author: Dmitry Azarov
 * @Created: 2017-06-28
 */
public interface MessageDao {

    void createMessage(MessageEntity messageEntity);
}
