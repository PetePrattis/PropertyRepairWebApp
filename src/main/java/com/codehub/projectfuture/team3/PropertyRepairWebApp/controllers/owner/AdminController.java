package com.codehub.projectfuture.team3.PropertyRepairWebApp.controllers.owner;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Repair;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairStatus;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.OwnerModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.OwnerService;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private RepairService repairService;

    @GetMapping("/admin")
    public String adminHomePageView(Model model) {
        List<Repair> repairList = repairService.findFirst10ByOrderByDateAscAndRepairStatus(RepairStatus.INPROGRESS);

        model.addAttribute("repairList", repairList);
        return "pages/adminHomePage";
    }

    @GetMapping("/admin/owners")
    public String adminShowOwners(Model model) {
        List<OwnerModel> ownerList = ownerService.getAllOwners();
        model.addAttribute("ownerList", ownerList);
        return "pages/owner/owners";
    }
}
