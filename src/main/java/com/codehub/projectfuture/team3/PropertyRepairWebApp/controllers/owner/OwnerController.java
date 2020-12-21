package com.codehub.projectfuture.team3.PropertyRepairWebApp.controllers.owner;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.OwnerModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.PropertyModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.RepairModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.OwnerService;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.PropertyService;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OwnerController {
    private static final String USER_ROLE = "userType";
    private static final String OWNERS_FORM = "ownersForm";

    @Autowired
    private OwnerService ownerService;
    @Autowired
    private RepairService repairService;
    @Autowired
    private PropertyService propertyService;

//    @GetMapping("/owner/home")
//    public String ownerrHomePageView(Model model) {
//        String mail = SecurityContextHolder.getContext().getAuthentication().getName();
//        OwnerModel owner = ownerService.findOwnerByEmail(mail);
//
//        List<RepairModel> repairList = repairService.getRepairsByAfm(owner.getAfm());
//        model.addAttribute("repairList", repairList);
//        return "pages/ownerHomePage";
//    }

    @GetMapping("/owner/properties")
    public String ownerPropertyView(Model model) {
        String mail = SecurityContextHolder.getContext().getAuthentication().getName();
        OwnerModel owner = ownerService.findOwnerByEmail(mail);

        List<PropertyModel> propertyList = propertyService.findPropertyByOwnerAfm(owner.getAfm());
        model.addAttribute("propertyList", propertyList);
        return "pages/ownerProperties";
    }
}
