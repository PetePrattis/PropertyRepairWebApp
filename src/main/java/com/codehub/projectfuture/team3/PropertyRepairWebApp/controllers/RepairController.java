package com.codehub.projectfuture.team3.PropertyRepairWebApp.controllers;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Repair;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RepairController {
    @Autowired
    private RepairService repairService;

    @GetMapping("/repair")
    public String repairView(Model model){
        List<Repair> repairList = repairService.getRepairsByAfm(1234567892L);

        model.addAttribute("aRepair", repairList.get(0));
        return "Index2";
    }
}