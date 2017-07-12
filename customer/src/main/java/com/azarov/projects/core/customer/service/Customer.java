package com.azarov.projects.core.customer.service;

import com.azarov.projects.core.address.service.AddressInfo;
import com.azarov.projects.core.authorization.service.Authorization;
import com.azarov.projects.core.business.customer.service.BusinessCustomer;

import java.util.List;

/**
 * Created by AzarovD on 25.08.2016.
 */

public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private String middleName;
    private BusinessCustomer businessCustomer;
    private List<AddressInfo> addressInfos;
    private Authorization authorizationInfo;

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

    public BusinessCustomer getBusinessCustomer() {
        return businessCustomer;
    }

    public void setBusinessCustomer(BusinessCustomer businessCustomer) {
        this.businessCustomer = businessCustomer;
    }

    public List<AddressInfo> getAddressInfos() {
        return addressInfos;
    }

    public void setAddressInfos(List<AddressInfo> addressInfos) {
        this.addressInfos = addressInfos;
    }

    public Authorization getAuthorizationInfo() {
        return authorizationInfo;
    }

    public void setAuthorizationInfo(Authorization authorizationInfo) {
        this.authorizationInfo = authorizationInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != customer.id) return false;
        if (firstName != null ? !firstName.equals(customer.firstName) : customer.firstName != null) return false;
        if (lastName != null ? !lastName.equals(customer.lastName) : customer.lastName != null) return false;
        if (middleName != null ? !middleName.equals(customer.middleName) : customer.middleName != null) return false;
        if (businessCustomer != null ? !businessCustomer.equals(customer.businessCustomer) : customer.businessCustomer != null)
            return false;
        if (addressInfos != null ? !addressInfos.equals(customer.addressInfos) : customer.addressInfos != null)
            return false;
        return authorizationInfo != null ? authorizationInfo.equals(customer.authorizationInfo) : customer.authorizationInfo == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (businessCustomer != null ? businessCustomer.hashCode() : 0);
        result = 31 * result + (addressInfos != null ? addressInfos.hashCode() : 0);
        result = 31 * result + (authorizationInfo != null ? authorizationInfo.hashCode() : 0);
        return result;
    }
}
