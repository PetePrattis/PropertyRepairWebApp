package com.codehub.projectfuture.team3.PropertyRepairWebApp.controllers.repair;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.RepairModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RepairController {
    private static final String REPAIR_ATTR = "repair";
    private static final String REPAIR_TYPES = "repairTypes";
    private static final String REPAIR_STATUS = "repairStatus";
    private static final String REPAIRS_FORM = "repairsForm";


    @Autowired
    private RepairService repairService;

    @GetMapping("/repair")
    public String repairView(Model model){
        List<RepairModel> repairList = repairService.getRepairsByAfm(1234567892L);

        model.addAttribute("aRepair", repairList.get(0));
        return "Index2";
    }


    @GetMapping("/search/repair")
    public String searchRepairView(Model model) {
        return "pages/repair/search_repair";
    }
}