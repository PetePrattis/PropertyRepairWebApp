package com.codehub.projectfuture.team3.PropertyRepairWebApp.services;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Property;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.PropertyForm;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.PropertyModel;

import java.util.List;
import java.util.Optional;

public interface PropertyService {

    PropertyModel findPropertyById(Long id);

    List<PropertyModel> getAllProperties();

    PropertyModel findPropertyByPropertyCode(String propertyCode);

    //Optional<PropertyModel> findPropertyByOwnerId(Long id);

    List<PropertyModel> findPropertyByOwnerAfm(Long id);

    void deletePropertyById(Long id);

    PropertyModel updateProperty(PropertyModel propertyModel);

    PropertyModel createProperty(PropertyForm propertyForm);

}
