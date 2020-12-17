package com.codehub.projectfuture.team3.PropertyRepairWebApp.controllers.repair;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairStatus;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairType;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.RepairForm;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CreateRepairController {
    private static final String REPAIR_ATTR = "repair";
    private static final String REPAIR_TYPES = "repairTypes";
    private static final String REPAIR_STATUS = "repairStatus";
    private static final String REPAIRS_FORM = "repairsForm";

    @Autowired
    private RepairService repairService;

    @GetMapping(value = "/repair/create")
    public String createRepair(Model model) {
        model.addAttribute(REPAIRS_FORM, new RepairForm());
        model.addAttribute(REPAIR_STATUS, RepairStatus.values());
        model.addAttribute(REPAIR_TYPES, RepairType.values());
        return "pages/repair/create_repair";
    }

    @PostMapping(value = "/admin/repair/create")
    public String createOwner(Model model, @Valid @ModelAttribute(REPAIRS_FORM) RepairForm repairForm,
                              BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/admin/owners/create";
        }
        repairService.createRepair(repairForm);
        return "redirect:/admin";
    }


}
