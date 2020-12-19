package com.codehub.projectfuture.team3.PropertyRepairWebApp.controllers.owner;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Repair;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairStatus;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.OwnerModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.PropertyModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.RepairModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.OwnerService;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.PropertyService;
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

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/admin/home")
    public String adminHomePageView(Model model) {
        List<RepairModel> repairList = repairService.findFirst10ByOrderByDateAscAndRepairStatus(RepairStatus.INPROGRESS);

        model.addAttribute("repairList", repairList);
        return "pages/adminHomePage";
    }

    @GetMapping("/admin/owners")
    public String adminShowOwners(Model model) {
        List<OwnerModel> ownerList = ownerService.getAllOwners();
        model.addAttribute("ownerList", ownerList);
        return "pages/owner/owners";
    }

    @GetMapping("/admin/repairs")
    public String adminShowRepairs(Model model) {
        List<RepairModel> repairModelList = repairService.getAllRepairs();
        model.addAttribute("repairList", repairModelList);
        return "pages/repair/repairs";
    }

    @GetMapping("/admin/properties")
    public String adminShowProperties(Model model) {
        List<PropertyModel> propertyModelList = propertyService.getAllProperties();
        model.addAttribute("propertyList", propertyModelList);
        return "pages/property/properties";
    }
}
