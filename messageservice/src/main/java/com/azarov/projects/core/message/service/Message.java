package com.azarov.projects.core.message.service;

/**
 * Copyright DonRiver Inc. All Rights Reserved.
 *
 * @Author: Dmitry Azarov
 * @Created: 2017-06-28
 */

public class Message {

    int sender;
    int recipient;
    byte[] content;
    String tokenAlias;

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public int getRecipient() {
        return recipient;
    }

    public void setRecipient(int recipient) {
        this.recipient = recipient;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getTokenAlias() {
        return tokenAlias;
    }

    public void setTokenAlias(String tokenAlias) {
        this.tokenAlias = tokenAlias;
    }
}
