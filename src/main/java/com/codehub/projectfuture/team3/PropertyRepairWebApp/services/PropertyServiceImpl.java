package com.codehub.projectfuture.team3.PropertyRepairWebApp.services;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Property;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.PropertyForm;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers.PropertyFormToPropertyMapper;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers.PropertyToPropertyModelMapper;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.PropertyModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService{

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyToPropertyModelMapper propertyToPropertyModel;

    @Autowired
    private PropertyFormToPropertyMapper propertyFormToProperty;

    @Override
    public PropertyModel findPropertyById(Long id) {
        Optional<Property> property = propertyRepository.findById(id);
        return propertyToPropertyModel.map(property.get());
    }

    @Override
    public List<PropertyModel> getAllProperties() {
        return propertyRepository
                .findAll()
                .stream()
                .map(property -> propertyToPropertyModel.map(property))
                .collect(Collectors.toList());
    }

    @Override
    public PropertyModel findPropertyByPropertyCode(String propertyCode) {
        Optional<Property> property = propertyRepository.findPropertyByPropertyCode(propertyCode);
        //todo exception
        return propertyToPropertyModel.map(property.get());
//                .findPropertyByPropertyCode(propertyCode)
//                .map(property -> propertyToPropertyModel.map(property));
    }

    @Override
    public List<PropertyModel> findPropertyByOwnerAfm(Long Afm) {
        //Optional<Property> property = propertyRepository.findPropertyByOwnerAfm(Afm);
        //todo exception
        return propertyRepository
                .findPropertyByOwnerAfm(Afm)
                .stream()
                .map(property -> propertyToPropertyModel.map(property))
                .collect(Collectors.toList());

               // map(property.get());
//                .findPropertyByOwnerId(id)
//                .map(property -> propertyToPropertyModel.map(property));
    }


    @Override
    public void deletePropertyById(Long id) {
        propertyRepository.deleteById(id);
    }

    @Override
    public PropertyModel updateProperty(PropertyModel propertyModel) {
        Property originalProperty = propertyRepository.findById(propertyModel.getId()).get();
//        originalProperty.setFirstName(originalProperty.getFirstName());
//        originalProperty.setAfm(originalProperty.getAfm());
//        originalProperty.setLastName(originalProperty.getLastName());
//        originalProperty.setAddress(originalProperty.getAddress());
//        originalProperty.setEmail(originalProperty.getEmail());
//        originalProperty.setTelephoneNumber(originalProperty.getTelephoneNumber());

        Property newProperty = propertyRepository.save(originalProperty);
        return propertyToPropertyModel.map(newProperty);
    }

    @Override
    public PropertyModel createProperty(PropertyForm propertyForm) {
        Property property = propertyFormToProperty.map(propertyForm);

        Property newProperty = propertyRepository.save(property);
        return propertyToPropertyModel.map(newProperty);
    }
}

