package com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers;


import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Repair;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.RepairModel;
import org.springframework.stereotype.Component;

@Component
public class RepairToRepairModelMapper {

    public RepairModel map(Repair repair) {
        RepairModel repairModel = new RepairModel();
        repairModel.setAddress(repair.getAddress());
        repairModel.setCost(repair.getCost());
        repairModel.setDate(repair.getDate());
        repairModel.setId(repair.getId());
        repairModel.setExtraInfo(repair.getExtraInfo());
        repairModel.setOwner(repair.getOwner());
        repairModel.setRepairStatus(repair.getRepairStatus());
        repairModel.setRepairType(repair.getRepairType());
        return repairModel;
    }


}


