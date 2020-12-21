package com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers;


import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.UserRole;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.OwnerForm;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class OwnerFormToOwnerMapper {

    public Owner map(OwnerForm ownerForm) {
        Owner owner = new Owner();
        owner.setAfm(Long.parseLong(ownerForm.getAfm()));
        owner.setFirstName(ownerForm.getFirstName());
        owner.setLastName(ownerForm.getLastName());
        owner.setAddress(ownerForm.getAddress());
        owner.setTelephoneNumber(ownerForm.getTelephoneNumber());
        owner.setEmail(ownerForm.getEmail());
        owner.setPassword("password");
        owner.setUserRole(UserRole.valueOf(ownerForm.getUserRole()));

        return owner;
    }

}
