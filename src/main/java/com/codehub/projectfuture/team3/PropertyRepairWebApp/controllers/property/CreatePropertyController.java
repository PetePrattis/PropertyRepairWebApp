package com.codehub.projectfuture.team3.PropertyRepairWebApp.controllers.property;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.PropertyType;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions.OnCreatePropertyException;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.PropertyForm;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.PropertyService;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.validators.PropertyFormValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static com.codehub.projectfuture.team3.PropertyRepairWebApp.utils.GlobalAttributes.ERROR_MESSAGE;

@Controller
public class CreatePropertyController {
    private static final String PROPERTY_TYPES = "propertyTypes";
    private static final String PROPERTIES_FORM = "propertiesForm";

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private PropertyFormValidation propertyFormValidation;

    @InitBinder(PROPERTIES_FORM)
    protected void initBinder(final WebDataBinder binder) {
        binder.addValidators(propertyFormValidation);
    }


    @GetMapping(value = "admin/property/create")
    public String createProperty(Model model) {
        model.addAttribute(PROPERTIES_FORM, new PropertyForm());
        model.addAttribute(PROPERTY_TYPES, PropertyType.values());
        return "pages/property/create_property";
    }

    @PostMapping(value = "/admin/property/create")
    public String createProperty(Model model, @Valid @ModelAttribute(PROPERTIES_FORM) PropertyForm propertyForm,
                              BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            model.addAttribute(PROPERTY_TYPES, PropertyType.values());
            model.addAttribute(ERROR_MESSAGE, "Validation errors occurred!");
            return "pages/property/create_property";
        }
        propertyService.createProperty(propertyForm);
        return "redirect:/admin/properties";
    }

    @ExceptionHandler({OnCreatePropertyException.class})
    public String handleOwnerNotFoundError(HttpServletRequest request,
                                           RedirectAttributes redirectAttributes,
                                           OnCreatePropertyException e)
    {
        redirectAttributes.addFlashAttribute(ERROR_MESSAGE, "error.property.create.owner.null");
        return "redirect:/error/generic";
    }

}
