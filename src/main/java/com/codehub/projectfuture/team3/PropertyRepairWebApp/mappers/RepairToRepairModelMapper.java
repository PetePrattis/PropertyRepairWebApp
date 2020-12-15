package com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers;


import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Repair;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairStatus;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.RepairModel;
import org.springframework.stereotype.Component;

@Component
public class RepairToRepairModelMapper {

    public RepairModel map(Repair repair) {
        RepairModel repairModel = new RepairModel();
        repairModel.setAddress(repair.getAddress());
        repairModel.setCost(repair.getCost());
        //TODO format date
        repairModel.setDate(repair.getDate().toString());
        repairModel.setId(repair.getId());
        repairModel.setExtraInfo(repair.getExtraInfo());
        repairModel.setOwnerAfm(repair.getOwner().getId());
        repairModel.setRepairStatus(repair.getRepairStatus().getStatus());
        repairModel.setRepairType(repair.getRepairType().getType());
        return repairModel;
    }
}


