package com.codehub.projectfuture.team3.PropertyRepairWebApp.validators;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.OwnerForm;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.OwnerModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.Optional;

@Component
public class OwnerFormValidation implements Validator {
    private static final String AFM_PATTERN = "[0-9]{9}";

    @Autowired
    private OwnerService ownerService;

    @Override
    public boolean supports(Class<?> aClass) {
        return OwnerForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        OwnerForm registrationForm = (OwnerForm) target;
        // Here we add our custom validation logic
        if(registrationForm.getAfm().matches(AFM_PATTERN))
        {
            Optional<Owner> ownerByAfm = ownerService.findOwnerByAfmOptional(Long.valueOf(registrationForm.getAfm()));
            if (ownerByAfm.isPresent()) {
                errors.rejectValue("afm", "register.afm.taken.error");
            }
        }
        Optional<Owner> ownerByEmail = ownerService.findOwnerByEmailOptional(registrationForm.getEmail());
        if (ownerByEmail.isPresent()) {
            errors.rejectValue("email", "register.email.taken.error");
        }
        // Or use reject if empty or whitespace
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "register.not.null.or.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "register.not.null.or.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "register.not.null.or.empty");
    }
}

