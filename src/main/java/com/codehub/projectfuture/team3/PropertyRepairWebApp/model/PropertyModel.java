package com.codehub.projectfuture.team3.PropertyRepairWebApp.model;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.PropertyType;

public class PropertyModel {

    private Long id;
    private String propertyCode;
    private String address;
    private Integer constructionYear;
    private PropertyType propertyType;
    //private OwnerModel ownerModel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(Integer constructionYear) {
        this.constructionYear = constructionYear;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

}
