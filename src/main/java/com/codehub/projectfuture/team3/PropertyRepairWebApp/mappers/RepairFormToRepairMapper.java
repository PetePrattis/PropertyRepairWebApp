package com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Property;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Repair;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairStatus;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairType;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions.OwnerNotFoundException;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions.PropertyNotFoundException;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.RepairForm;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.repositories.OwnerRepository;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class RepairFormToRepairMapper {
    @Autowired
    private PropertyRepository propertyRepository;

    public Repair map(RepairForm repairForm) throws OwnerNotFoundException{
        Repair repair = new Repair();
        repair.setDate(LocalDate.parse(repairForm.getDate()));
        repair.setRepairStatus(RepairStatus.valueOf(repairForm.getRepairStatus()));
        repair.setRepairType(RepairType.valueOf(repairForm.getRepairType()));
        repair.setCost(Float.parseFloat(repairForm.getCost()));
        repair.setAddress(repairForm.getAddress());
        repair.setExtraInfo(repairForm.getExtraInfo());
        Optional<Property> property = propertyRepository.findPropertyByPropertyCode(repairForm.getPropertyCode());
        if (property.isEmpty()) throw new PropertyNotFoundException();
        repair.setProperty(property.get());

        return repair;
    }
}
