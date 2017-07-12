package com.azarov.projects.core.business.customer.service;

/**
 * Created by AzarovD on 25.08.2016.
 */

public class BusinessCustomer {

    private int businessId;
    private BusinessCustomerType type;
    private BusinessCustomerStatus status;

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public BusinessCustomerStatus getStatus() {
        return status;
    }

    public void setStatus(BusinessCustomerStatus status) {
        this.status = status;
    }

    public BusinessCustomerType getType() {
        return type;
    }

    public void setType(BusinessCustomerType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BusinessCustomer that = (BusinessCustomer) o;

        if (businessId != that.businessId) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return status != null ? status.equals(that.status) : that.status == null;

    }

    @Override
    public int hashCode() {
        int result = businessId;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
