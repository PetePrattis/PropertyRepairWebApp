package com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers;


import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.PropertyType;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.OwnerForm;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class OwnerFormToOwnerMapper {

    public Owner map(OwnerForm ownerForm) {
        Owner owner = new Owner();
        owner.setFirstName(ownerForm.getFirstName());
        owner.setLastName(ownerForm.getLastName());
        // Let's talk about the elephant in the room
        owner.setPropertyType(PropertyType.valueOf(ownerForm.getPropertyType()));
        owner.setAfm(Long.parseLong(ownerForm.getAfm()));
        return owner;
    }

//    private LocalDate parseLocalDateFromString(String date) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //ex: '1939-01-01'
//        return LocalDate.parse(date, formatter);
//    }

}
