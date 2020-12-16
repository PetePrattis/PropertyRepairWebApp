package com.codehub.projectfuture.team3.PropertyRepairWebApp.controllers.rapair;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.RepairSearchForm;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.RepairModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class SearchRepairController {
    private static final String REPAIR_FORM = "repairSearchForm";

    @Autowired
    private RepairService repairService;

    @GetMapping("/admin/search/byDate/repair")
    public String searchRepairByDateView(Model model)
    {
        model.addAttribute(REPAIR_FORM, new RepairSearchForm());
        return "pages/repair/search_repair_byDate";
    }

    @GetMapping("/admin/search/betweenDate/repair")
    public String searchRepairBetweenDateView(Model model)
    {
        model.addAttribute(REPAIR_FORM, new RepairSearchForm());
        return "pages/repair/search_repair_betweenDate";
    }

    @GetMapping("/admin/search/byOwnersAfm/repair")
    public String searchRepairByOwnerAfmView(Model model)
    {
        model.addAttribute(REPAIR_FORM, new RepairSearchForm());
        return "pages/repair/search_repair_byAFM";
    }

    @PostMapping("/admin/search/byAfm/repair")
    public String searchRepairView(@ModelAttribute(REPAIR_FORM)RepairSearchForm repairSearchForm, Model model) {

        List<RepairModel> repairList = repairService.getRepairsByAfm(Long.parseLong(repairSearchForm.getInput()));

        model.addAttribute("repairList", repairList);
        return "pages/adminHomePage";
    }

    @PostMapping("/admin/search/byDate/repair")
    public String searchRepairByDateView(@ModelAttribute(REPAIR_FORM)RepairSearchForm repairSearchForm, Model model) {

        List<RepairModel> repairList = repairService.findRepairByDate(LocalDate.parse(repairSearchForm.getInput()));

        model.addAttribute("repairList", repairList);
        return "pages/adminHomePage";
    }

    @PostMapping("/admin/search/betweenDate/repair")
    public String searchRepairBetweenDateView(@ModelAttribute(REPAIR_FORM) RepairSearchForm repairSearchForm, Model model) {

        List<RepairModel> repairList = repairService.findRepairByDateBetween(LocalDate.parse(repairSearchForm.getInput()),LocalDate.parse(repairSearchForm.getInput2()));

        model.addAttribute("repairList", repairList);
        return "pages/adminHomePage";
    }

}
