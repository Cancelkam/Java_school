package com.javaSchool.eCare.controller;

import com.javaSchool.eCare.model.dto.user.UserAccountForm;
import com.javaSchool.eCare.model.entity.Contract;
import com.javaSchool.eCare.model.entity.UserEntity;
import com.javaSchool.eCare.service.api.UserService;
import com.javaSchool.eCare.service.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserAccountForm userAccountForm() {
        return new UserAccountForm();
    }

    @GetMapping(value = "employee/allUsers")
    public String getUsers(Model model) {
        List<UserEntity> users = userService.findAll();
        List<UserAccountForm> usersDto = new ArrayList<UserAccountForm>();
        for (UserEntity user : users) {
            usersDto.add(new UserAccountForm(user));
        }
        model.addAttribute("users", usersDto);
        return "employee/allUsers";
    }
}
