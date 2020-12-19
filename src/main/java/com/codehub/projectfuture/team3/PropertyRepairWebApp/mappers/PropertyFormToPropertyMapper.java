package com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Property;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.PropertyType;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions.OwnerNotFoundException;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions.PropertyNotFoundException;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.PropertyForm;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PropertyFormToPropertyMapper {
    @Autowired
    private OwnerRepository ownerRepository;

    public Property map(PropertyForm propertyForm) throws OwnerNotFoundException {
        Property property = new Property();
        property.setPropertyCode(propertyForm.getPropertyCode());
        property.setAddress(propertyForm.getAddress());
        property.setConstructionYear(Integer.parseInt(propertyForm.getConstructionYear()));
        property.setPropertyType(PropertyType.valueOf(propertyForm.getPropertyType()));

        Optional<Owner> owner = ownerRepository.findOwnerByAfm(Long.valueOf(propertyForm.getOwnerAfm()));
        if (owner.isEmpty()) throw new OwnerNotFoundException();
        property.setOwner(owner.get());

        return property;
    }

}
