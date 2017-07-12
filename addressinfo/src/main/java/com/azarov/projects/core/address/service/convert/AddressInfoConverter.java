package com.azarov.projects.core.address.service.convert;

import com.azarov.projects.core.address.datalayer.entity.AddressInfoEntity;
import com.azarov.projects.core.address.service.AddressInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright DonRiver Inc. All Rights Reserved.
 *
 * @Author: Dmitry Azarov
 * @Created: 2017-06-27
 */

@Service("addressInfoConverter")
public class AddressInfoConverter {

    public List<AddressInfo> toAddressInfos(List<AddressInfoEntity> addressInfoEntities){
        List<AddressInfo> addressInfos = new ArrayList<>();
        for (AddressInfoEntity entity : addressInfoEntities){
            addressInfos.add(toAddressInfo(entity));
        }
        return addressInfos;
    }

    public AddressInfo toAddressInfo(AddressInfoEntity entity){
        AddressInfo addressInfo= new AddressInfo();
        addressInfo.setAddressInfoId(entity.getAddressInfoId());
        addressInfo.setCity(entity.getCity());
        addressInfo.setCountry(entity.getCountry());
        addressInfo.setDistrict(entity.getDistrict());
        addressInfo.setStreet(entity.getStreet());
        addressInfo.setBuilding(entity.getBuilding());
        addressInfo.setCustomerId(entity.getCustomerId());
        return addressInfo;
    }

    public List<AddressInfoEntity> toAddressInfoEntity(List<AddressInfo> addressInfos){
        List<AddressInfoEntity> entities = new ArrayList<>();
        for (AddressInfo addressInfo : addressInfos){
            entities.add(toAddressInfoEntity(addressInfo));
        }
        return entities;
    }

    public AddressInfoEntity toAddressInfoEntity(AddressInfo addressInfo){
        AddressInfoEntity entity= new AddressInfoEntity();
        entity.setAddressInfoId(addressInfo.getAddressInfoId());
        entity.setCity(addressInfo.getCity());
        entity.setCountry(addressInfo.getCountry());
        entity.setDistrict(addressInfo.getDistrict());
        entity.setStreet(addressInfo.getStreet());
        entity.setBuilding(addressInfo.getBuilding());
        entity.setCustomerId(addressInfo.getCustomerId());
        return entity;
    }
}
