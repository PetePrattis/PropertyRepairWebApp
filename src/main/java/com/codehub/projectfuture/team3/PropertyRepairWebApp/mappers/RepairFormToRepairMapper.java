package com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Repair;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairStatus;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairType;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.RepairForm;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDate;

@Component
public class RepairFormToRepairMapper {
    @Autowired
    private OwnerRepository ownerRepository;

    public Repair map(RepairForm repairForm){
        Repair repair = new Repair();
        repair.setDate(LocalDate.parse(repairForm.getDate()));
        repair.setRepairStatus(RepairStatus.valueOf(repairForm.getRepairStatus()));
        repair.setRepairType(RepairType.valueOf(repairForm.getRepairType()));
        repair.setCost(Float.parseFloat(repairForm.getCost()));
        repair.setAddress(repairForm.getAddress());
        repair.setExtraInfo(repairForm.getExtraInfo());
        repair.setOwner(ownerRepository.findOwnerByAfm(Long.valueOf(repairForm.getOwnerAfm())).get());
        //TODO setOwnerAFM

        return repair;
    }
}