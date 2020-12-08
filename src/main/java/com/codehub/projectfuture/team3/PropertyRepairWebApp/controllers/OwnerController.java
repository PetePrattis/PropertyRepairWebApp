package com.codehub.projectfuture.team3.PropertyRepairWebApp.controllers;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping({"/", "/login"})
    public String ownerLoginView(Model model) {
        Owner owner = ownerService.findOwnerById(1L).orElseThrow();

        model.addAttribute("anOwner", owner);
        return "Index";
    }

    @GetMapping("/admin")
    public String adminHomePageView(Model model) {
        Owner owner = ownerService.findOwnerById(1L).orElseThrow();

        model.addAttribute("anOwner", owner);
        return "Index";
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
}
