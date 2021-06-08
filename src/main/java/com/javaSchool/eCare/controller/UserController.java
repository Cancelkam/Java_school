package com.javaSchool.eCare.controller;

import com.javaSchool.eCare.model.dto.Tariff.TariffViewForm;
import com.javaSchool.eCare.model.dto.contract.ContractViewForm;
import com.javaSchool.eCare.model.dto.user.UserAccountForm;
import com.javaSchool.eCare.model.entity.Contract;
import com.javaSchool.eCare.model.entity.UserEntity;
import com.javaSchool.eCare.service.api.ContractService;
import com.javaSchool.eCare.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    private final ContractService contractService;

    @Autowired
    public UserController(UserService userService, ContractService contractService) {
        this.userService = userService;
        this.contractService = contractService;
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
        return "/employee/allUsers";
    }


    @GetMapping(value = "/employee/search/result")
    public String findContractByNumber(@RequestParam(value = "number", required = true) String number, Model model) {
        UserEntity user = userService.getUserByNumber(number);
        List<UserAccountForm> usersDto = new ArrayList<UserAccountForm>();

        usersDto.add(new UserAccountForm(user));
        model.addAttribute("users", usersDto);
        return "/employee/allUsers";
    }

    //    @GetMapping(value = "/client/hello/{id}")
//    public String findUserById(@PathVariable("id") int id, Model model) {
//        UserEntity user = userService.getEntityById(id);
//        model.addAttribute("user",user);
//        return "/client/hello";
//    }
    @GetMapping(value = "/client/{id}/yourContract")
    public String findContractByUserId(@PathVariable("id") int id, Model model) {
        List<Contract> contracts = userService.getContractByUserId(id);
        List<ContractViewForm> contractDto = contractService.getContractViewList(contracts);
//        List<ContractViewForm> contractDto = new ArrayList<ContractViewForm>();
//        for (Contract contract : contracts) {
//            contractDto.add(new ContractViewForm(contract));
//        }
        model.addAttribute("contracts", contractDto);
        return "client/yourContract";

    }

    @GetMapping(value = "employee/editUser/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        UserEntity user = userService.getEntityById(id);
//        List<UserAccountForm> usersDto = new ArrayList<UserAccountForm>();
//        usersDto.add(new UserAccountForm(user));
        UserAccountForm usersDto = new UserAccountForm(user);
        model.addAttribute("user", usersDto);
//                List<UserAccountForm> userDto = userService.getUserViewList((Collection<UserEntity>) user);
//        List<UserAccountForm> usersDto = new ArrayList<UserAccountForm>();
//        usersDto.add(new UserAccountForm(user));
        return "/employee/editUser";
    }

    @PostMapping(value = "employee/editUser/{id}")
    public String saveUser(@PathVariable("id") int id, @ModelAttribute("user") @Valid UserAccountForm userAccountForm) throws ParseException {
        userService.updateUser(userAccountForm.toUserEntity());
        return "redirect:/employee/allUsers";
    }

    @GetMapping(value = "employee/addUserPage")
    public String addUserPage() {
        return "/employee/addUser";
    }

    @PostMapping(value = "employee/addUser")
    public String addUser(@ModelAttribute("user") @Valid UserAccountForm userAccountForm) throws ParseException {
        userService.createNewUser(userAccountForm.toUserEntity());
        return "redirect:/employee/allUsers";
    }


    @PostMapping(value = "employee/user/{idUser}/contract/{idContract}/unblock")
    public String unblockContract(@PathVariable int idUser, @PathVariable int idContract) {
        userService.unblockContractByAdmin(idContract);
        return "redirect:employee/allContracts";
    }

    @PostMapping(value = "employee/user/{idUser}/contract/{idContract}/block")
    public String blockContract(@PathVariable int idUser, @PathVariable int idContract) {
        userService.blockContractByAdmin(idContract);
        return "redirect:employee/allContracts";
    }

}
