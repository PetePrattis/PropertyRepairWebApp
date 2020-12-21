package com.codehub.projectfuture.team3.PropertyRepairWebApp.controllers.repair;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairStatus;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairType;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions.OnCreateRepairException;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.RepairForm;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.RepairService;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.validators.RepairFormValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class CreateRepairController {
    private static final String REPAIR_ATTR = "repair";
    private static final String REPAIR_TYPES = "repairTypes";
    private static final String REPAIR_STATUS = "repairStatus";
    private static final String REPAIRS_FORM = "repairsForm";
    private static final String ERROR_MESSAGE = "errorMessage";

    @Autowired
    private RepairService repairService;

    @Autowired
    private RepairFormValidation repairFormValidation;

    @InitBinder(REPAIRS_FORM)
    protected void initBinder(final WebDataBinder binder) {
        binder.addValidators(repairFormValidation);
    }


    @GetMapping(value = "/admin/repair/create")
    public String createRepair(Model model) {
        model.addAttribute(REPAIRS_FORM, new RepairForm());
        model.addAttribute(REPAIR_STATUS, RepairStatus.values());
        model.addAttribute(REPAIR_TYPES, RepairType.values());
        return "pages/repair/create_repair";
    }

    @PostMapping(value = "/admin/repair/create")
    public String createOwner(Model model, @Valid @ModelAttribute(REPAIRS_FORM) RepairForm repairForm,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            model.addAttribute(REPAIR_STATUS, RepairStatus.values());
            model.addAttribute(REPAIR_TYPES, RepairType.values());
            model.addAttribute(ERROR_MESSAGE, "Validation errors occurred!");
            return "pages/repair/create_repair";
        }
        repairService.createRepair(repairForm);
        return "redirect:/admin/repairs";
    }

    @ExceptionHandler({OnCreateRepairException.class})
    public String handleOwnerNotFoundError(HttpServletRequest request,
                                           RedirectAttributes redirectAttributes,
                                           OnCreateRepairException e)
    {
        redirectAttributes.addFlashAttribute(ERROR_MESSAGE, "error.repair.create.owner.null");
        return "redirect:/error/generic";
    }

}
