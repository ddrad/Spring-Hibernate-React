package com.azarov.projects.core.business.customer.service.convert;

import com.azarov.projects.core.business.customer.datalayer.entity.BusinessCustomerEntity;
import com.azarov.projects.core.business.customer.service.BusinessCustomer;
import org.springframework.stereotype.Service;

/**
 * Created by AzarovD on 25.08.2016.
 */

@Service("businessCustomerConvert")
public class BusinessCustomerConvert {

    public BusinessCustomer toBusinessCustomer(BusinessCustomerEntity entity) {
        BusinessCustomer businessCustomer = new BusinessCustomer();
        businessCustomer.setBusinessId(entity.getBusinessId());
        businessCustomer.setStatus(entity.getStatus());
        businessCustomer.setType(entity.getType());
        return businessCustomer;
    }

    public BusinessCustomerEntity toBusinessCustomerEntity(BusinessCustomer business) {
        BusinessCustomerEntity entity = new BusinessCustomerEntity();
        entity.setBusinessId(business.getBusinessId());
        entity.setStatus(business.getStatus());
        entity.setType(business.getType());
        return entity;
    }


}
