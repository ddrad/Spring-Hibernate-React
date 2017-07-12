package com.azarov.projects.core.message.datalayer.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Copyright DonRiver Inc. All Rights Reserved.
 *
 * @Author: Dmitry Azarov
 * @Created: 2017-06-28
 */
@Embeddable
public class MessagePK implements Serializable {

    @Column(name = "sender_token")
    private String senderToken;
    @Column(name = "message_token")
    private String messageTokken;

    public String getSenderToken() {
        return senderToken;
    }

    public void setSenderToken(String senderToken) {
        this.senderToken = senderToken;
    }

    public String getMessageTokken() {
        return messageTokken;
    }

    public void setMessageTokken(String messageTokken) {
        this.messageTokken = messageTokken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessagePK messagePK = (MessagePK) o;

        if (senderToken != null ? !senderToken.equals(messagePK.senderToken) : messagePK.senderToken != null)
            return false;
        return messageTokken != null ? messageTokken.equals(messagePK.messageTokken) : messagePK.messageTokken == null;
    }

    @Override
    public int hashCode() {
        int result = senderToken != null ? senderToken.hashCode() : 0;
        result = 31 * result + (messageTokken != null ? messageTokken.hashCode() : 0);
        return result;
    }
}
