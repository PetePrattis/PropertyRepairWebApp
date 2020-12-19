package com.codehub.projectfuture.team3.PropertyRepairWebApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    private static final String ERROR_MESSAGE = "errorMessage";

    @GetMapping("/login")
    private String login() {
        return "login";
    }

    @GetMapping("/login/failed")
    private String loginFailed(Model model) {
        model.addAttribute(ERROR_MESSAGE, "Login failed, try again");
        return "login";
    }
}
