package com.codehub.projectfuture.team3.PropertyRepairWebApp.controllers.property;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.PropertyType;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions.OwnerNotFoundException;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions.PropertyNotFoundException;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.OwnerModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.PropertyModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class EditPropertyController {
    private static final String PROPERTY_ATTR = "property";
    private static final String PROPERTY_TYPES = "propertyType";
    private static final String ERROR_MESSAGE = "errorMessage";

    @Autowired
    private PropertyService propertyService;

    @GetMapping(value = "/property/{id}/edit")
    public String editProperty(@PathVariable Long id, Model model) {
        PropertyModel propertyModel = propertyService.findPropertyById(id);
        model.addAttribute(PROPERTY_ATTR, propertyModel);
        model.addAttribute(PROPERTY_TYPES, PropertyType.values());
        return "pages/property/property_edit";
    }

    @PostMapping(value = "/admin/property/edit")
    public String editProperty(PropertyModel propertyModel) {
        propertyService.updateProperty(propertyModel);
        return "redirect:/admin/properties";
    }

    @PostMapping(value = "/property/{id}/delete")
    public String deleteProperty(@PathVariable Long id) {
        propertyService.deletePropertyById(id);
        return "redirect:/admin/properties";
    }

    @ExceptionHandler({PropertyNotFoundException.class})
    public String handleOwnerNotFoundError(HttpServletRequest request,
                                           RedirectAttributes redirectAttributes,
                                           PropertyNotFoundException e)
    {
        redirectAttributes.addFlashAttribute(ERROR_MESSAGE, "error.property.null");
        return "redirect:/error/generic";
    }

    @ExceptionHandler({OwnerNotFoundException.class})
    public String handleOwnerNotFoundError(HttpServletRequest request,
                                           RedirectAttributes redirectAttributes,
                                           OwnerNotFoundException e)
    {
        redirectAttributes.addFlashAttribute(ERROR_MESSAGE, "error.property.update.owner.null");
        return "redirect:/error/generic";
    }
}
