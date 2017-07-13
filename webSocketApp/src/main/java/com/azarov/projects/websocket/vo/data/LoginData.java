package com.azarov.projects.websocket.vo.data;

/**
 * Created by AzarovD on 23.08.2016.
 */
public class LoginData extends Data {

    String login;
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

        LoginData data = (LoginData) o;

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
