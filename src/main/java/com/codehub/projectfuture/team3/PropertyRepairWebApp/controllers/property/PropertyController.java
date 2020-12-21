package com.codehub.projectfuture.team3.PropertyRepairWebApp.controllers.property;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.PropertyModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/property")
    public String propertyView(Model model){
        List<PropertyModel> propertyList = propertyService.findPropertyByOwnerAfm(1234567891L);
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
