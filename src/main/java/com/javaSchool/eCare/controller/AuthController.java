package com.javaSchool.eCare.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class AuthController {
    private boolean hasAnyRole() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth != null
                && auth.isAuthenticated()
                && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("EMPLOYEE")
                || a.getAuthority().equals("CLIENT"));
    }

    @GetMapping(value = {"/login", "/login/{error}"})
    public String login(@PathVariable(required = false) boolean error) {
        if(hasAnyRole()) {
            return "redirect:/homePage";
        }

        if(error) {
            // TODO print message for failed authentication
        }

        return "login";
    }
}
