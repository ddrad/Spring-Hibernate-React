package com.azarov.projects.core.authorization.service;

/**
 * Created by AzarovD on 25.08.2016.
 */

public class Authorization {

    private String login;
    private String password;
    private int customerId;

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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
