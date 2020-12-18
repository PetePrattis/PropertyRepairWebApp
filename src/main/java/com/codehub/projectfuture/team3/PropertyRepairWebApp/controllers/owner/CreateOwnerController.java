package com.codehub.projectfuture.team3.PropertyRepairWebApp.controllers.owner;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.PropertyType;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.UserRole;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.OwnerForm;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.OwnerModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.OwnerService;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.validators.OwnerFormValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CreateOwnerController {
    private static final String OWNERS_FORM = "ownersForm";
    private static final String PROPERTY_TYPES = "propertyType";
    private static final String USER_ROLE = "userRole";
    private static final String ERROR_MESSAGE = "errorMessage";

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private OwnerFormValidation ownerFormValidation;


    @InitBinder(OWNERS_FORM)
    protected void initBinder(final WebDataBinder binder) {
        binder.addValidators(ownerFormValidation);
    }

    @GetMapping(value = "/admin/owners/create")
    public String createOwnerView(Model model) {
        model.addAttribute(OWNERS_FORM, new OwnerForm());
        model.addAttribute(PROPERTY_TYPES, PropertyType.values());
        model.addAttribute(USER_ROLE, UserRole.values());
        return "pages/owner/owner_create";
    }

    @PostMapping(value = "/admin/owners/create")
    public String createOwner(Model model, @Valid @ModelAttribute(OWNERS_FORM) OwnerForm ownerForm,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            model.addAttribute(PROPERTY_TYPES, PropertyType.values());
            model.addAttribute(USER_ROLE, UserRole.values());
            model.addAttribute(ERROR_MESSAGE, "validation errors occurred");
            return "pages/owner/owner_create";
        }
        OwnerModel owner = ownerService.createOwner(ownerForm);
        redirectAttributes.addAttribute("id",owner.getId());
        return "redirect:/admin/owners";
    }
}
