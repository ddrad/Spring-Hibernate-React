package com.azarov.projects.websocket.vo.data;

/**
 * Created by AzarovD on 23.08.2016.
 */

public enum ErrorCode {

    CUSTOMER_NOT_FOUND("Customer not found"),
    CUSTOMER_NOT_CREATED("Customer not created"),
    MESSAGE_WAS_NOT_SPENT("Message was not sent");

    private final String name;

    private ErrorCode(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
