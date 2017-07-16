package com.azarov.projects.websocket.vo.request;


/**
 * Created by AzarovD on 23.08.2016.
 */
public abstract class TokenMessage {

    String type;
    String sequenceId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TokenMessage that = (TokenMessage) o;

        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return sequenceId != null ? sequenceId.equals(that.sequenceId) : that.sequenceId == null;

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (sequenceId != null ? sequenceId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TokenMessage{" +
                "type='" + type + '\'' + ", sequenceId='" + sequenceId + '\'' + '}';
    }
}
