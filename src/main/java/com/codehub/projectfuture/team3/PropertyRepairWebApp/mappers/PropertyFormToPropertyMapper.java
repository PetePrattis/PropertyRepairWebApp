package com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Property;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.PropertyType;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.PropertyForm;
import org.springframework.stereotype.Component;

@Component
public class PropertyFormToPropertyMapper {

    public Property map(PropertyForm propertyForm){
        Property property = new Property();
        property.setPropertyCode(propertyForm.getPropertyCode());
        property.setAddress(propertyForm.getAddress());
        property.setConstructionYear(Integer.parseInt(propertyForm.getConstructionYear()));
        property.setPropertyType(PropertyType.valueOf(propertyForm.getPropertyType()));
        //setOwner

        return property;
    }

}
