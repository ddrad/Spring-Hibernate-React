package com.azarov.projects.core.address.datalayer.dao.impl;

import com.azarov.projects.core.address.datalayer.dao.AbstractDao;
import com.azarov.projects.core.address.datalayer.dao.AddressInfoDao;
import com.azarov.projects.core.address.datalayer.entity.AddressInfoEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Copyright DonRiver Inc. All Rights Reserved.
 *
 * @Author: Dmitry Azarov
 * @Created: 2017-06-27
 */
@Repository("addressInfoDao")
public class AddressInfoDaoImpl extends AbstractDao implements AddressInfoDao {

    @Override
    @Transactional
    public AddressInfoEntity saveAddress(AddressInfoEntity entity) {
        return (AddressInfoEntity) persist(entity);
    }

    @Override
    @Transactional
    public AddressInfoEntity findById(int id) {
        return null;
    }

    @Override
    @Transactional
    public List<AddressInfoEntity> findAllCustomer() {
        return null;
    }

    @Override
    @Transactional
    public void updateAddress(AddressInfoEntity entity) {

    }
}
