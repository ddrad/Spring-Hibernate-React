package com.azarov.projects.websocket.vo.tokenmessage;

import com.azarov.projects.websocket.vo.data.DataCreateCustomerRequest;
import com.azarov.projects.websocket.vo.data.SendMessageRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Dmitiy on 29.08.2016.
 */
public class TokenSendMessageRequest extends TokenMessage {

    @JsonProperty("data")
    SendMessageRequest data;

    public SendMessageRequest getData() {
        return data;
    }

    public void setData(SendMessageRequest data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TokenSendMessageRequest that = (TokenSendMessageRequest) o;

        return data != null ? data.equals(that.data) : that.data == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}
