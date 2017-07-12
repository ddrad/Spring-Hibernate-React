package com.azarov.projects.websocket.vo.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by AzarovD on 23.08.2016.
 */
public class SendMessageRequest extends Data {
    @JsonProperty("sender")
    int sender;
    @JsonProperty("recipient")
    int recipient;
    @JsonProperty("content")
    String content;
    @JsonProperty("msgTokenAlias")
    String msgTokenAlias;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMsgTokenAlias() {
        return msgTokenAlias;
    }

    public void setMsgTokenAlias(String msgTokenAlias) {
        this.msgTokenAlias = msgTokenAlias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SendMessageRequest that = (SendMessageRequest) o;

        if (sender != that.sender) return false;
        if (recipient != that.recipient) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        return msgTokenAlias != null ? msgTokenAlias.equals(that.msgTokenAlias) : that.msgTokenAlias == null;
    }

    @Override
    public int hashCode() {
        int result = sender;
        result = 31 * result + recipient;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (msgTokenAlias != null ? msgTokenAlias.hashCode() : 0);
        return result;
    }
}
