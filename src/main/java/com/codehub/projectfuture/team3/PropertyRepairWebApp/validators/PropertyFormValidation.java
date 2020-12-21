package com.codehub.projectfuture.team3.PropertyRepairWebApp.validators;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Property;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.PropertyForm;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.PropertyModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.OwnerService;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class PropertyFormValidation implements Validator {
    private static final String AFM_PATTERN = "[0-9]{9}";

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private PropertyService propertyService;

    @Override
    public boolean supports(Class<?> aClass) {
        return PropertyForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PropertyForm registrationForm = (PropertyForm) target;
        // Here we add our custom validation logic
        if(registrationForm.getOwnerAfm().matches(AFM_PATTERN))
        {
            Optional<Owner> ownerByAfm = ownerService.findOwnerByAfmOptional(Long.valueOf(registrationForm.getOwnerAfm()));
            if (ownerByAfm.isEmpty()) {
                errors.rejectValue("ownerAfm", "repair.afm..error");
            }
        }
        Optional<Property> property = propertyService.findPropertyByPropertyCodeOptional(registrationForm.getPropertyCode());
        if (property.isEmpty()) {
            errors.rejectValue("propertyCode", "property.code.taken.error");
        }
        // Or use reject if empty or whitespace
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "constructionYear", "register.not.null.or.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "register.not.null.or.empty");
    }
}

