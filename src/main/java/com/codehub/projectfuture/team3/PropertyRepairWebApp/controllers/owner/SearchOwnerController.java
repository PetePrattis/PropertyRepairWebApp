package com.codehub.projectfuture.team3.PropertyRepairWebApp.controllers.owner;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions.OwnerNotFoundException;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.OwnerSearchForm;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.OwnerModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

import static com.codehub.projectfuture.team3.PropertyRepairWebApp.utils.GlobalAttributes.ERROR_MESSAGE;

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

        OwnerModel owner;
        try
        {
            owner = ownerService.findOwnerByAfm(Long.parseLong(ownerSearchForm.getInput()));
        }
        catch (OwnerNotFoundException e)
        {
            owner = null;
        }

        model.addAttribute("owner", owner);
        return "pages/owner/owner";
    }

    @PostMapping("/admin/search/byEmail/owner")
    public String searchOwnerByEmailView(@ModelAttribute(OWNER_FORM)OwnerSearchForm ownerSearchForm, Model model) {

        OwnerModel owner;
        try
        {
            owner = ownerService.findOwnerByEmail(ownerSearchForm.getInput());
        }
        catch (OwnerNotFoundException e)
        {
            owner = null;
        }

        model.addAttribute("owner", owner);
        return "pages/owner/owner";
    }

    @ExceptionHandler({OwnerNotFoundException.class})
    public String handleOwnerNotFoundError(HttpServletRequest request,
                                           RedirectAttributes redirectAttributes,
                                           OwnerNotFoundException e)
    {
        redirectAttributes.addFlashAttribute(ERROR_MESSAGE, "error.owner.null");
        return "redirect:/error/generic";
    }
}
