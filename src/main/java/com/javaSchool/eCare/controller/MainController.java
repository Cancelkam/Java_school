package com.javaSchool.eCare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping(value = {"/"})
    public String welcomePage(Model model) {
        return "index";
    }

    @GetMapping(value = {"/login"})
    public String loginPage(Model model) {
        return "login";
    }

    @GetMapping("employee/hello")
    public String employeePage(Model model) {
        return "employee/hello";
    }

    @GetMapping("client/hello")
    public String clientPage( Model model) {
        return "/client/hello";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}