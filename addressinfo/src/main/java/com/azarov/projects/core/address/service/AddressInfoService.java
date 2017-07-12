package com.azarov.projects.core.address.service;

import java.util.List;

/**
 * Copyright DonRiver Inc. All Rights Reserved.
 *
 * @Author: Dmitry Azarov
 * @Created: 2017-06-27
 */
public interface AddressInfoService {

    AddressInfo createAddressInfo(AddressInfo addressInfo);

    AddressInfo findById(String id);

    List<AddressInfo> findAllEmployees();

    void updateCustomer(AddressInfo customer);
}
