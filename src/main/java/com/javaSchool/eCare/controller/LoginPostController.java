package com.javaSchool.eCare.controller;

import org.springframework.stereotype.Controller;
import com.javaSchool.eCare.config.domain.NoSuchRoleException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginPostController {
    @GetMapping(value = "/loginPost")
    public String loginPost() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("EMPLOYEE"))) {
            return "redirect:/employee/hello";
        } else if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("CLIENT"))) {
            return "redirect:/client/hello";
        } else {
            throw new NoSuchRoleException("Invalid user role");
        }
    }
}
