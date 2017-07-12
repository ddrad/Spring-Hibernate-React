package com.azarov.projects.core.address.datalayer.entity;


import javax.persistence.*;

/**
 * Copyright DonRiver Inc. All Rights Reserved.
 *
 * @Author: Dmitry Azarov
 * @Created: 2017-06-27
 */

@Entity
@Table(name = "address_info")
public class AddressInfoEntity {

    @Id
    @Column(name = "address_info_id")
    @SequenceGenerator(name = "address_info_id_seq", sequenceName = "address_info_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_info_id_seq")
    private int addressInfoId;

    @Column(name = "country", nullable = false)
    private String country;
    @Column(name = "city", nullable = true)
    private String city;
    @Column(name = "district", nullable = true)
    private String district;
    @Column(name = "street", nullable = true)
    private String street;
    @Column(name = "building", nullable = true)
    private String building;
    @Column(name = "customer_id", nullable = true)
    private int  customerId;

    public int getAddressInfoId() {
        return addressInfoId;
    }

    public void setAddressInfoId(int addressInfoId) {
        this.addressInfoId = addressInfoId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
