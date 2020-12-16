package com.codehub.projectfuture.team3.PropertyRepairWebApp.controllers.owner;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.OwnerSearchForm;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.OwnerModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchOwnerController {
    private static final String OWNER_FORM = "ownerSearchForm";

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/admin/search/byAFM/owner")
    public String searchOwnerByAFMView(Model model)
    {
        model.addAttribute(OWNER_FORM, new OwnerSearchForm());
        return "pages/owner/search_owner_byAFM";
    }

    @GetMapping("/admin/search/byEmail/owner")
    public String searchOwnerByEmailView(Model model)
    {
        model.addAttribute(OWNER_FORM, new OwnerSearchForm());
        return "pages/owner/search_owner_byEmail";
    }

    @PostMapping("/admin/search/byAfm/owner")
    public String searchOwnerView(@ModelAttribute(OWNER_FORM)OwnerSearchForm ownerSearchForm, Model model) {

        OwnerModel ownerst = ownerService.findOwnerByAfm(Long.parseLong(ownerSearchForm.getInput())).get();

        model.addAttribute("owner", ownerst);
        return "pages/owner/owner";
    }

    @PostMapping("/admin/search/byEmail/owner")
    public String searchOwnerByEmailView(@ModelAttribute(OWNER_FORM)OwnerSearchForm ownerSearchForm, Model model) {

        OwnerModel ownerst = ownerService.findOwnerByEmail(ownerSearchForm.getInput()).get();

        model.addAttribute("owner", ownerst);
        return "pages/owner/owner";
    }
}
