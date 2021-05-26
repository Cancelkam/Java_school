package com.javaSchool.eCare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping(value = {"/"})
    public String welcomePage() { return "index"; }

    @GetMapping(value = {"/login"})
    public String loginPage() {
        return "login";
    }

    @GetMapping("employee/hello")
    public String employeePage() {
        return "employee/hello";
    }

    @GetMapping("client/hello")
    public String clientPage() {
        return "client/hello";
    }

//    @GetMapping("employee/addTariff")
//    public String saveTariff() {
//        return "employee/addTariff";
//    }

    @GetMapping("employee/addUser")
    public String saveUser() { return "employee/addUser"; }

    @GetMapping("/403")
    public String error403() { return "/error/403"; }
}