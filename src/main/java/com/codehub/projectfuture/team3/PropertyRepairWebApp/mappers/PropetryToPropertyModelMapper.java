package com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Property;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.PropertyType;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.PropertyModel;
import org.springframework.stereotype.Component;

@Component
public class PropetryToPropertyModelMapper {

    public PropertyModel map(Property property){
        PropertyModel propertyModel = new PropertyModel();
        propertyModel.setPropertyCode(Long.parseLong(property.getPropertyCode()));
        propertyModel.setAddress(property.getAddress());
        propertyModel.setConstructionYear(property.getConstructionYear());
        propertyModel.setPropertyType(property.getPropertyType());
        //setOwner

        return propertyModel;
    }

}
