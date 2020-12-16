package com.codehub.projectfuture.team3.PropertyRepairWebApp.controllers.rapair;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairStatus;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairType;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.RepairModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditRepairController {
    private static final String REPAIR_ATTR = "repair";
    private static final String REPAIR_TYPES = "repairTypes";
    private static final String REPAIR_STATUS = "repairStatus";

    @Autowired
    private RepairService repairService;

    @GetMapping(value = "/repair/{id}/edit")
    public String editRepair(@PathVariable Long id, Model model) {
        RepairModel repairModel = repairService.findRepairById(id).get();
        model.addAttribute(REPAIR_ATTR, repairModel);
        model.addAttribute(REPAIR_STATUS, RepairStatus.values());
        model.addAttribute(REPAIR_TYPES, RepairType.values());
        return "pages/repair/repair_edit";
    }

    @PostMapping(value = "/repair/edit")
    public String editRepair(RepairModel repairModel) {
        repairService.updateRepair(repairModel);
        return "redirect:/admin";
    }

    @PostMapping(value = "/repair/{id}/delete")
    public String deleteRepair(@PathVariable Long id) {
        repairService.deleteRepairById(id);
        return "redirect:/admin/repairs";
    }


}
