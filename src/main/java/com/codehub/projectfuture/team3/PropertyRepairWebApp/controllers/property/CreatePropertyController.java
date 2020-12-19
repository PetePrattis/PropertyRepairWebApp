package com.codehub.projectfuture.team3.PropertyRepairWebApp.controllers.property;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.PropertyType;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairStatus;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.PropertyForm;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CreatePropertyController {
    private static final String PROPERTY_TYPES = "propertyTypes";
    private static final String PROPERTIES_FORM = "propertiesForm";

    @Autowired
    private PropertyService propertyService;

    @GetMapping(value = "/property/create")
    public String createProperty(Model model) {
        model.addAttribute(PROPERTIES_FORM, new PropertyForm());
        model.addAttribute(PROPERTY_TYPES, PropertyType.values());
        return "pages/property/create_property";
    }

    @PostMapping(value = "/admin/property/create")
    public String createProperty(Model model, @Valid @ModelAttribute(PROPERTIES_FORM) PropertyForm propertyForm,
                              BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/admin/property/create";
        }
        propertyService.createProperty(propertyForm);
        return "redirect:/admin/properties";
    }

}
