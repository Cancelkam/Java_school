package com.javaSchool.eCare.controller;

import com.javaSchool.eCare.model.dto.user.UserAccountForm;
import com.javaSchool.eCare.model.entity.UserEntity;
import com.javaSchool.eCare.service.api.UserService;
import com.javaSchool.eCare.service.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/Users")
    public String getUsers(ModelMap model) {
        model.addAttribute("users", userService.findAll());
        return "allUsers";
    }

    @ModelAttribute("user")
    public UserAccountForm userAccountForm() {return new UserAccountForm(); }

//    @ModelAttribute("users")
//    public List<UserEntity> userAccountForm(){return userService.findAll();}


//@GetMapping(value = "/client/account")
//    public String getName(ModelMap model){
//model.addAttribute("users",userService.)
//}


}
