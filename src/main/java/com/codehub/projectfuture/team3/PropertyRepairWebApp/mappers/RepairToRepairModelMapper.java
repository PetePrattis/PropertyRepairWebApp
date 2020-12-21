package com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers;


import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Repair;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.RepairModel;
import org.springframework.stereotype.Component;

@Component
public class RepairToRepairModelMapper {

    public RepairModel map(Repair repair) {
        RepairModel repairModel = new RepairModel();
        repairModel.setAddress(repair.getAddress());
        repairModel.setCost(String.valueOf(repair.getCost()));
        //TODO format date
        repairModel.setDate(repair.getDate().toString());
        repairModel.setId(repair.getId());
        repairModel.setExtraInfo(repair.getExtraInfo());
        repairModel.setOwnerAfm(repair.getOwner().getAfm());
        repairModel.setRepairStatus(repair.getRepairStatus());
        repairModel.setRepairType(repair.getRepairType());
        return repairModel;
    }
}


