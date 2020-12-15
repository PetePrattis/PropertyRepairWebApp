package com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Repair;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairStatus;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.RepairForm;

import java.sql.Timestamp;

public class RepairFormToRepairMapper {

    public Repair map(RepairForm repairForm){
        Repair repair = new Repair();
        repair.setDate(Timestamp.valueOf(repairForm.getDate()));
        repair.setRepairStatus(RepairStatus.valueOf(repairForm.getRepairStatus()));
        repair.setCost(Float.parseFloat(repairForm.getCost()));
        repair.setAddress(repairForm.getAddress());
        repair.setExtraInfo(repairForm.getExtraInfo());
        //TODO setOwnerAFM

        return repair;
    }
}
