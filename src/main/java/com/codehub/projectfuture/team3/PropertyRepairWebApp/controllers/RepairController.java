package com.codehub.projectfuture.team3.PropertyRepairWebApp.controllers;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Repair;
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

import java.util.List;

@Controller
public class RepairController {
    private static final String REPAIR_ATTR = "repair";
    private static final String REPAIR_TYPES = "repairTypes";
    private static final String REPAIR_STATUS = "repairStatus";


    @Autowired
    private RepairService repairService;

    @GetMapping("/repair")
    public String repairView(Model model){
        List<Repair> repairList = repairService.getRepairsByAfm(1234567892L);

        model.addAttribute("aRepair", repairList.get(0));
        return "Index2";
    }

    @PostMapping("/create-repair")
    public String createRepairView(Model model) {
        return "Index";
    }

    @PostMapping("/edit-repair")
    public String editRepairView(Model model) {
        return "Index";
    }

    @GetMapping(value = "/repair/{id}/edit")
    public String editBook(@PathVariable Long id, Model model) {
        RepairModel bookModel = repairService.findRepair(id).get();
        model.addAttribute(REPAIR_ATTR, bookModel);
        model.addAttribute(REPAIR_STATUS, RepairStatus.values());
        model.addAttribute(REPAIR_TYPES, RepairType.values());
        return "pages/repair_edit";
    }


    @PostMapping("/search-repair")
    public String searchRepairView(Model model) {
        return "Index";
    }
}