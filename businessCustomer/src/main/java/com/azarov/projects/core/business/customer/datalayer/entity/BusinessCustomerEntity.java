package com.azarov.projects.core.business.customer.datalayer.entity;

import com.azarov.projects.core.business.customer.service.BusinessCustomerStatus;
import com.azarov.projects.core.business.customer.service.BusinessCustomerType;

import javax.persistence.*;

/**
 * Created by AzarovD on 25.08.2016.
 */


@Entity
@Table(name = "business_customer")
public class BusinessCustomerEntity {
    @Id
    @Column(name = "business_id")
    @SequenceGenerator(name = "business_customer_id_seq", sequenceName = "business_customer_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "business_customer_id_seq")
    private int businessId;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private BusinessCustomerType type;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private BusinessCustomerStatus status;

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public BusinessCustomerType getType() {
        return type;
    }

    public void setType(BusinessCustomerType type) {
        this.type = type;
    }

    public BusinessCustomerStatus getStatus() {
        return status;
    }

    public void setStatus(BusinessCustomerStatus status) {
        this.status = status;
    }
}
