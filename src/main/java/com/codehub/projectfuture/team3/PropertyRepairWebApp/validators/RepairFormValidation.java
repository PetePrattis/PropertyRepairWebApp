package com.codehub.projectfuture.team3.PropertyRepairWebApp.validators;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Property;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.RepairForm;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.OwnerService;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class RepairFormValidation implements Validator {
    private static final String AFM_PATTERN = "[0-9]{9}";

    @Autowired
    private PropertyService propertyService;
    private Optional<Property> property;

    @Override
    public boolean supports(Class<?> aClass) {
        return RepairForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RepairForm registrationForm = (RepairForm) target;
        // Here we add our custom validation logic
        
        Optional<Property> property = propertyService.findPropertyByPropertyCodeOptional(registrationForm.getPropertyCode());
        if (property.isEmpty()) {
            errors.rejectValue("propertyCode", "repair.afm..error");
        }

        // Or use reject if empty or whitespace
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cost", "register.not.null.or.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "register.not.null.or.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "register.not.null.or.empty");
    }
}

