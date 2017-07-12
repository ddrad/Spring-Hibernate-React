package com.azarov.projects.core.address.service.impl;

import com.azarov.projects.core.address.datalayer.dao.AddressInfoDao;
import com.azarov.projects.core.address.datalayer.entity.AddressInfoEntity;
import com.azarov.projects.core.address.service.AddressInfo;
import com.azarov.projects.core.address.service.AddressInfoService;
import com.azarov.projects.core.address.service.convert.AddressInfoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright DonRiver Inc. All Rights Reserved.
 *
 * @Author: Dmitry Azarov
 * @Created: 2017-06-27
 */
@Service("addressInfoService")
public class AddressInfoServiceImpl implements AddressInfoService {
    @Autowired
    @Qualifier("addressInfoDao")
    private AddressInfoDao dao;
    @Autowired
    @Qualifier("addressInfoConverter")
    private AddressInfoConverter converter;
    @Override
    public AddressInfo createAddressInfo(AddressInfo addressInfo) {
        AddressInfoEntity addressInfoEntity = dao.saveAddress(converter.toAddressInfoEntity(addressInfo));
        return converter.toAddressInfo(addressInfoEntity);
    }

    @Override
    public AddressInfo findById(String id) {
        return null;
    }

    @Override
    public List<AddressInfo> findAllEmployees() {
        return null;
    }

    @Override
    public void updateCustomer(AddressInfo customer) {

    }
}
