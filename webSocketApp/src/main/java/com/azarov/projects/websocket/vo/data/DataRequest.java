package com.azarov.projects.websocket.vo.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by AzarovD on 23.08.2016.
 */
public class DataRequest extends Data {
    @JsonProperty("login")
    String login;
    @JsonProperty("password")
    String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataRequest data = (DataRequest) o;

        if (login != null ? !login.equals(data.login) : data.login != null) return false;
        return password != null ? password.equals(data.password) : data.password == null;

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Data{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
