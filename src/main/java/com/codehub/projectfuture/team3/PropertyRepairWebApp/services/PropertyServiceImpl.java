package com.codehub.projectfuture.team3.PropertyRepairWebApp.services;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Property;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions.OnCreatePropertyException;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions.OwnerNotFoundException;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions.PropertyNotFoundException;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.PropertyForm;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers.PropertyFormToPropertyMapper;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers.PropertyToPropertyModelMapper;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.PropertyModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.repositories.OwnerRepository;
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

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public PropertyModel findPropertyById(Long id) {
        Optional<Property> property = propertyRepository.findById(id);
        if (property.isEmpty()) throw new PropertyNotFoundException();
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
        if (property.isEmpty()) throw new PropertyNotFoundException();
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
        Optional<Property>  originalProperty = propertyRepository.findById(propertyModel.getId());
        if (originalProperty.isEmpty()) throw new PropertyNotFoundException();
        originalProperty.get().setPropertyCode(propertyModel.getPropertyCode());
        originalProperty.get().setAddress(propertyModel.getAddress());
        originalProperty.get().setConstructionYear(propertyModel.getConstructionYear());
        originalProperty.get().setPropertyType(propertyModel.getPropertyType());

        Optional<Owner> owner = ownerRepository.findOwnerByAfm(propertyModel.getOwnerAfm());
        if (owner.isEmpty()) throw new OwnerNotFoundException();

        originalProperty.get().setOwner(owner.get());

        Property newProperty = propertyRepository.save(originalProperty.get());
        return propertyToPropertyModel.map(newProperty);
    }

    @Override
    public PropertyModel createProperty(PropertyForm propertyForm) {
        try {
            Property property = propertyFormToProperty.map(propertyForm);
            Property newProperty = propertyRepository.save(property);
            return propertyToPropertyModel.map(newProperty);
        } catch (OwnerNotFoundException e) {
            throw new OnCreatePropertyException();
        }
    }
}

