package com.azarov.projects.core.address.datalayer.dao;

import com.azarov.projects.core.address.datalayer.entity.AddressInfoEntity;

import java.util.List;

/**
 * Copyright DonRiver Inc. All Rights Reserved.
 *
 * @Author: Dmitry Azarov
 * @Created: 2017-06-27
 */
public interface AddressInfoDao {

    AddressInfoEntity saveAddress(AddressInfoEntity entity);

    AddressInfoEntity findById(int id);

    List<AddressInfoEntity> findAllCustomer();

    void updateAddress(AddressInfoEntity entity);
}
