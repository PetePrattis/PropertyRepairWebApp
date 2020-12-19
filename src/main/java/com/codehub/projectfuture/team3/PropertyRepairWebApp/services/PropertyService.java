package com.codehub.projectfuture.team3.PropertyRepairWebApp.services;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Property;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions.OnCreatePropertyException;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions.OwnerNotFoundException;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions.PropertyNotFoundException;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.PropertyForm;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.PropertyModel;

import java.util.List;
import java.util.Optional;

public interface PropertyService {

    PropertyModel findPropertyById(Long id) throws PropertyNotFoundException;

    List<PropertyModel> getAllProperties();

    PropertyModel findPropertyByPropertyCode(String propertyCode) throws PropertyNotFoundException;

    List<PropertyModel> findPropertyByOwnerAfm(Long id);

    void deletePropertyById(Long id);

    PropertyModel updateProperty(PropertyModel propertyModel) throws PropertyNotFoundException;

    PropertyModel createProperty(PropertyForm propertyForm) throws OnCreatePropertyException;

}
