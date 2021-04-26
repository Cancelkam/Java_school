package com.javaSchool.eCare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = {"/"})
    public String welcomePage(Model model) {

        model.addAttribute("example", "example message");

        return "/index";
    }
}