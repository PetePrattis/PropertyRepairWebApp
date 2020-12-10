package com.codehub.projectfuture.team3.PropertyRepairWebApp.controllers;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Repair;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairStatus;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.OwnerService;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class OwnerController {
    @Autowired
    private OwnerService ownerService;
    @Autowired
    private RepairService repairService;

    @GetMapping({"/", "/login"})
    public String ownerLoginView(Model model) {
        Owner owner = ownerService.findOwnerById(1L).orElseThrow();

        model.addAttribute("anOwner", owner);
        return "Index";
    }

    @GetMapping("/admin")
    public String adminHomePageView(Model model) {
        List<Repair> repairList = repairService.findFirst10ByOrderByDateAscAndRepairStatus(RepairStatus.INPROGRESS);

        model.addAttribute("repairList", repairList);
        return "adminHomePage";
    }

    @GetMapping("/owner")
    public String ownerHomePageView(Model model) {
        Owner owner = ownerService.findOwnerById(1L).orElseThrow();

        model.addAttribute("anOwner", owner);
        return "Index";
    }

    @PostMapping("/create-owner")
    public String createOwnerView(Model model) {
        Owner owner = ownerService.findOwnerById(1L).orElseThrow();

        model.addAttribute("anOwner", owner);
        return "Index";
    }

    @PostMapping("/edit-owner")
    public String editOwnerView(Model model) {
        Owner owner = ownerService.findOwnerById(1L).orElseThrow();

        model.addAttribute("anOwner", owner);
        return "Index";
    }

    @PostMapping("/search-owner")
    public String searchOwnerView(Model model) {
        Owner owner = ownerService.findOwnerById(1L).orElseThrow();

        model.addAttribute("anOwner", owner);
        return "Index";
    }

    @PostMapping("owner")
    public Owner addOwner(@RequestBody Owner owner){
        return ownerService.addOwner(owner);
    }
}
