package com.javaSchool.eCare.controller;

import com.javaSchool.eCare.dao.interfaces.UserRepository;
import com.javaSchool.eCare.model.entity.UserEntity;
import com.javaSchool.eCare.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
public class MainController {

    private final UserService userService;

    @Autowired
    public MainController(UserRepository userRepository, UserService userService) {
        this.userService = userService;
    }

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
    public String clientPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = userService.getUserByEmail(auth.getName());
        model.addAttribute("user", user);
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