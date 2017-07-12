package com.azarov.projects.core.message.datalayer.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Copyright DonRiver Inc. All Rights Reserved.
 *
 * @Author: Dmitry Azarov
 * @Created: 2017-06-28
 */

@Entity
@Table(name = "message")
public class MessageEntity implements Serializable{

    @EmbeddedId
    MessagePK id;
    @Column(name = "sender")
    int sender;
    @Column(name = "recipient")
    int recipient;
    @Column(name = "content")
    byte[] content;

    public MessagePK getId() {
        return id;
    }

    public void setId(MessagePK id) {
        this.id = id;
    }

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
}
