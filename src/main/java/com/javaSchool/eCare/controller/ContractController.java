package com.javaSchool.eCare.controller;

import com.javaSchool.eCare.model.dto.contract.ContractViewForm;
import com.javaSchool.eCare.model.entity.Contract;
import com.javaSchool.eCare.service.api.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ContractController {

    private final ContractService contractService;

    @Autowired
    ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @ModelAttribute("contract")
    public ContractViewForm contractViewForm() {
        return new ContractViewForm();
    }

    @GetMapping(value = "/allContracts")
    public String getContracts(Model model) {
        List<Contract> contracts = contractService.findAll();
        List<ContractViewForm> contractDto = new ArrayList<ContractViewForm>();
        for (Contract contract : contracts) {
            contractDto.add(new ContractViewForm(contract));
        }
        model.addAttribute("contracts", contractDto);
        return "employee/allContracts";
    }
}
