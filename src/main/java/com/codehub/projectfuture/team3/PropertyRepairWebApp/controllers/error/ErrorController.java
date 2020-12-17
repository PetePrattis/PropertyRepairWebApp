package com.codehub.projectfuture.team3.PropertyRepairWebApp.controllers.error;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/error/generic")
    public String getErrorPage(Model model) {
        return "pages/error";
    }
}
