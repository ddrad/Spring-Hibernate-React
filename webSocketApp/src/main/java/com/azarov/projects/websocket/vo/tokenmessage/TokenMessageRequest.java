package com.azarov.projects.websocket.vo.tokenmessage;

import com.azarov.projects.websocket.vo.data.DataRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by AzarovD on 23.08.2016.
 */
public class TokenMessageRequest extends TokenMessage {

    @JsonProperty("data")
    DataRequest data;

    public DataRequest getData() {
        return data;
    }

    public void setData(DataRequest data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TokenMessageRequest that = (TokenMessageRequest) o;

        return data != null ? data.equals(that.data) : that.data == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}
