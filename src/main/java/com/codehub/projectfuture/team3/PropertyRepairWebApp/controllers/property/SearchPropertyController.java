package com.codehub.projectfuture.team3.PropertyRepairWebApp.controllers.property;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.PropertySearchForm;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.RepairSearchForm;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.PropertyModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class SearchPropertyController {
    private static final String PROPERTY_FORM = "propertySearchForm";

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/admin/search/byPropertyCode/property")
    public String searchPropertyByPropertyCode(Model model)
    {
        model.addAttribute(PROPERTY_FORM, new RepairSearchForm());
        return "pages/property/search_property_byPropertyCode";
    }

    @GetMapping("/admin/property/byOwnersAfm/property")
    public String searchPropertyByOwnerAfmView(Model model)
    {
        model.addAttribute(PROPERTY_FORM, new RepairSearchForm());
        return "pages/property/search_property_byAFM";
    }

    @PostMapping("/admin/search/byPropertyCode/property")
    public String searchPropertyByPropertyCodeView(@ModelAttribute(PROPERTY_FORM) PropertySearchForm propertySearchForm, Model model) {
        PropertyModel propertyList = propertyService.findPropertyByPropertyCode(propertySearchForm.getInput());

        model.addAttribute("propertyList", propertyList);
        return "pages/adminHomePage";
    }

    @PostMapping("/admin/search/byAfm/property")
    public String searchPropertyView(@ModelAttribute(PROPERTY_FORM)PropertySearchForm propertySearchForm, Model model) {
        List<PropertyModel> propertyList = propertyService.findPropertyByOwnerAfm(Long.parseLong(propertySearchForm.getInput()));

        model.addAttribute("propertyList", propertyList);
        return "pages/adminHomePage";
    }

}
