package com.azarov.projects.core.message.service;

/**
 * Copyright DonRiver Inc. All Rights Reserved.
 *
 * @Author: Dmitry Azarov
 * @Created: 2017-06-28
 */
public interface MessageSenderService {

    void send(Message message, String tokenAlias);
}
