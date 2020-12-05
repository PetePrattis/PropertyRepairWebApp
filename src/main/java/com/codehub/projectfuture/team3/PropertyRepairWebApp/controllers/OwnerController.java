package com.codehub.projectfuture.team3.PropertyRepairWebApp.controllers;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping("/owner")
    public String ownerView(Model model){
        Owner owner = ownerService.findOwner(50L).orElseThrow();

        model.addAttribute("anOwner", owner);
        return "Index";
    }



}
