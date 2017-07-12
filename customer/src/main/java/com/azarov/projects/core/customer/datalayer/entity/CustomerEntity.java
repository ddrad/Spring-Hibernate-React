package com.azarov.projects.core.customer.datalayer.entity;

/**
 * Created by AzarovD on 25.08.2016.
 */

import javax.persistence.*;

import com.azarov.projects.core.business.customer.datalayer.entity.BusinessCustomerEntity;
import com.azarov.projects.core.authorization.datalayer.entity.AuthorizationEntity;

import java.util.List;

@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "customer_id_seq", sequenceName = "customer_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_seq")
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "middle_name", nullable = false)
    private String middleName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "business_id")
    private BusinessCustomerEntity businessCustomerEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authorization_id")
    private AuthorizationEntity authorizationInfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public BusinessCustomerEntity getBusinessCustomerEntity() {
        return businessCustomerEntity;
    }

    public void setBusinessCustomerEntity(BusinessCustomerEntity businessCustomerEntity) {
        this.businessCustomerEntity = businessCustomerEntity;
    }

    public AuthorizationEntity getAuthorizationInfo() {
        return authorizationInfo;
    }

    public void setAuthorizationInfo(AuthorizationEntity authorizationInfo) {
        this.authorizationInfo = authorizationInfo;
    }
}