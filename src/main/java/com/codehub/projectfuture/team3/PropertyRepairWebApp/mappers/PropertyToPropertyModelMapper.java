package com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Property;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.PropertyType;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.PropertyModel;
import org.springframework.stereotype.Component;

@Component
public class PropertyToPropertyModelMapper {

    public PropertyModel map(Property property){
        PropertyModel propertyModel = new PropertyModel();
        propertyModel.setPropertyCode(property.getPropertyCode());
        propertyModel.setAddress(property.getAddress());
        propertyModel.setConstructionYear(property.getConstructionYear());
        propertyModel.setPropertyType(property.getPropertyType());
        propertyModel.setOwnerId(property.getOwner().getAfm());

        return propertyModel;
    }

}
