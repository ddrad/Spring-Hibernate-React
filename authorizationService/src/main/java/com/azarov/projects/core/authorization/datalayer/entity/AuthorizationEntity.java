package com.azarov.projects.core.authorization.datalayer.entity;

import javax.persistence.*;

/**
 * Created by Dmitiy on 28.08.2016.
 */
@Entity
@Table(name = "authorization_data")
public class AuthorizationEntity {
    @Id
    @Column(name = "authorization_id")
    @SequenceGenerator(name = "authorization_data_id_seq", sequenceName = "authorization_data_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authorization_data_id_seq")
    private int authorizationId;
    @Column(name = "login")
    private String login;
    @Column(name = "email")
    private String email;
    @Column(name = "pswd")
    private String password;

    public int getAuthorizationId() {
        return authorizationId;
    }

    public void setAuthorizationId(int authorizationId) {
        this.authorizationId = authorizationId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
