package com.codehub.projectfuture.team3.PropertyRepairWebApp.controllers.owner;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.UserRole;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions.OwnerNotFoundException;
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

import static com.codehub.projectfuture.team3.PropertyRepairWebApp.utils.GlobalAttributes.ERROR_MESSAGE;

@Controller
public class EditOwnerController {
    private static final String OWNER_ATTR = "owner";
    private static final String USER_ROLE = "userRole";

    @Autowired
    private OwnerService ownerService;


    @GetMapping(value = "/admin/owner/{id}/edit")
    public String editRepair(@PathVariable Long id, Model model) {
        OwnerModel ownerModel = ownerService.findOwnerById(id);
        model.addAttribute(OWNER_ATTR, ownerModel);
        model.addAttribute(USER_ROLE, UserRole.values());
        return "pages/owner/owner_edit";
    }

    @PostMapping(value = "/admin/owner/edit")
    public String editOwner(OwnerModel ownerModel) {
        ownerService.updateOwner(ownerModel);
        return "redirect:/admin/owners";
    }

    @PostMapping(value = "/admin/owner/{id}/delete")
    public String deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwnerById(id);
        return "redirect:/admin/owners";
    }

    @ExceptionHandler({OwnerNotFoundException.class})
    public String handleOwnerNotFoundError(HttpServletRequest request,
                                           RedirectAttributes redirectAttributes,
                                           OwnerNotFoundException e)
    {
        redirectAttributes.addFlashAttribute(ERROR_MESSAGE, "error.owner.null");
        return "redirect:/error/generic";
    }

}
