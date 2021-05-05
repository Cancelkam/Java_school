package com.javaSchool.eCare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping(value = {"/"})
    public String welcomePage(Model model) {

        model.addAttribute("example", "example message");

        return "index";
    }

    @GetMapping(value = {"/login"})
    public String loginPage(@RequestParam(required = false) String login, Model model) {
        model.addAttribute("login" , login);
        return "login";
    }
    @GetMapping(value = {"/tariffs"})
    public String tariffPage(@RequestParam(required = false) String tariff, Model model) {
        model.addAttribute("tariff" , tariff);
        return "tariffs";
    }

}