package com.codehub.projectfuture.team3.PropertyRepairWebApp.forms;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class RepairForm {
    private static final String COST_PATTERN = "[0-9]+(\\.[0-9]+)?";
    private String date;

    @NotEmpty(message = "{register.not.null}")
    private String repairStatus;

    @NotEmpty(message = "{register.not.null}")
    private String repairType;

    private String cost;

    private String address;

    private String extraInfo;

    @NotEmpty(message = "{register.not.null}")
    private String propertyCode;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(String repairStatus) {
        this.repairStatus = repairStatus;
    }

    public String getRepairType() {
        return repairType;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public String getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode;
    }
}
