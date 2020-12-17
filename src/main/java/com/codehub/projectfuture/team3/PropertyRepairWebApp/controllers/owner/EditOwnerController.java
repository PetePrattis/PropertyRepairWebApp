package com.codehub.projectfuture.team3.PropertyRepairWebApp.controllers.owner;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.PropertyType;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceprions.OwnerNotFoundException;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.OwnerModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.OwnerService;
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
public class EditOwnerController {
    private static final String OWNER_ATTR = "owner";
    private static final String PROPERTY_TYPES = "propertyType";
    private static final String ERROR_MESSAGE = "errorMessage";

    @Autowired
    private OwnerService ownerService;


    @GetMapping(value = "/owner/{id}/edit")
    public String editRepair(@PathVariable Long id, Model model) {
        OwnerModel ownerModel = ownerService.findOwnerById(id);
        model.addAttribute(OWNER_ATTR, ownerModel);
        model.addAttribute(PROPERTY_TYPES, PropertyType.values());
        return "pages/owner/owner_edit";
    }

    @PostMapping(value = "/owner/edit")
    public String editBook(OwnerModel ownerModel) {
        ownerService.updateOwner(ownerModel);
        return "redirect:/admin/owners";
    }

    //TODO implement delete in JS modal
    @PostMapping(value = "/owner/{id}/delete")
    public String deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwnerById(id);
        return "redirect:/admin/owners";
    }

    @ExceptionHandler({OwnerNotFoundException.class})
    public String handleOwnerNotFoundError(HttpServletRequest request,
                                           RedirectAttributes redirectAttributes,
                                           OwnerNotFoundException e)
    {
        redirectAttributes.addFlashAttribute(ERROR_MESSAGE, "error.generic");
        return "redirect:/error/generic";
    }

}
