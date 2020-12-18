package com.codehub.projectfuture.team3.PropertyRepairWebApp.controllers.property;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.PropertyModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.RepairModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/property")
    public String propertyView(Model model){
        PropertyModel propertyList = propertyService.findPropertyByOwnerId(1L).orElseThrow();
                //findPropertyByOwnerId(1L);
                //findPropertyById(1L);

        model.addAttribute("aProperty", propertyList);
        return "Index2";
    }


    @GetMapping("/search/property")
    public String searchPropertyView(Model model) {
        return "pages/property/search_property";
    }
}
