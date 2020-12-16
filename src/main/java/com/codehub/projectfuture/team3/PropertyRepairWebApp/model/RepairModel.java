package com.codehub.projectfuture.team3.PropertyRepairWebApp.model;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairStatus;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

public class RepairModel {
    private Long id;
    private String date;
    private RepairStatus repairStatus;
    private RepairType repairType;
    private String cost;
    private String address;
    private String extraInfo;
    private Long ownerAfm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public RepairStatus getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(RepairStatus repairStatus) {
        this.repairStatus = repairStatus;
    }

    public RepairType getRepairType() {
        return repairType;
    }

    public void setRepairType(RepairType repairType) {
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

    public Long getOwnerAfm() {
        return ownerAfm;
    }

    public void setOwnerAfm(Long ownerAfm) {
        this.ownerAfm = ownerAfm;
    }
}
