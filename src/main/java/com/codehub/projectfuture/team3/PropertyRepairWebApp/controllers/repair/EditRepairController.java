package com.codehub.projectfuture.team3.PropertyRepairWebApp.controllers.repair;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairStatus;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairType;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions.OwnerNotFoundException;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions.RepairNotFoundException;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.RepairModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.RepairService;
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
public class EditRepairController {
    private static final String REPAIR_ATTR = "repair";
    private static final String REPAIR_TYPES = "repairTypes";
    private static final String REPAIR_STATUS = "repairStatus";

    @Autowired
    private RepairService repairService;

    @GetMapping(value = "/adminow/repair/{id}/edit")
    public String editRepair(@PathVariable Long id, Model model) {
        RepairModel repairModel = repairService.findRepairById(id);
        model.addAttribute(REPAIR_ATTR, repairModel);
        model.addAttribute(REPAIR_STATUS, RepairStatus.values());
        model.addAttribute(REPAIR_TYPES, RepairType.values());
        return "pages/repair/repair_edit";
    }

    @PostMapping(value = "/repair/edit")
    public String editRepair(RepairModel repairModel) {
        repairService.updateRepair(repairModel);
        return "redirect:/admin/repairs";
    }

    @PostMapping(value = "admin/repair/{id}/delete")
    public String deleteRepair(@PathVariable Long id) {
        repairService.deleteRepairById(id);
        return "redirect:/admin/repairs";
    }

    @ExceptionHandler(OwnerNotFoundException.class)
    public String handleOwnerNotFoundInUpdateError(HttpServletRequest request,
                                           RedirectAttributes redirectAttributes,
                                           OwnerNotFoundException e)
    {
        redirectAttributes.addFlashAttribute(ERROR_MESSAGE, "error.repair.update.owner.null");
        return "redirect:/error/generic";
    }

    @ExceptionHandler(RepairNotFoundException.class)
    public String handleRepairNotFoundError(HttpServletRequest request,
                                           RedirectAttributes redirectAttributes,
                                            RepairNotFoundException e)
    {
        redirectAttributes.addFlashAttribute(ERROR_MESSAGE, "error.repair.null");
        return "redirect:/error/generic";
    }
}
