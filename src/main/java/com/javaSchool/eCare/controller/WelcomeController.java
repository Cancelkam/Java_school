package com.javaSchool.eCare.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;

public class WelcomeController {
    @GetMapping(value = {"/"})
    public String loginPage() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null
                && auth.isAuthenticated()
                && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("EMPLOYEE")
                || a.getAuthority().equals("CLIENT"))) {
            return "redirect:/homePage";
        }
        return "login";
    }
}
