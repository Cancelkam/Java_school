package com.javaSchool.eCare.controller;

import com.javaSchool.eCare.model.dto.contract.ContractViewForm;
import com.javaSchool.eCare.model.entity.Contract;
import com.javaSchool.eCare.model.entity.Option;
import com.javaSchool.eCare.service.api.ContractService;
import com.javaSchool.eCare.service.api.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ContractController {

    private final ContractService contractService;
    private final OptionService optionService;

    @Autowired
    ContractController(ContractService contractService, OptionService optionService) {
        this.contractService = contractService;
        this.optionService = optionService;
    }

    @ModelAttribute("contract")
    public ContractViewForm contractViewForm() {
        return new ContractViewForm();
    }

    @GetMapping(value = "employee/allContracts")
    public String getContracts(Model model) {
        List<Contract> contracts = contractService.findAll();
        List<ContractViewForm> contractDto = contractService.getContractViewList(contracts);
        model.addAttribute("contracts", contractDto);
        return "employee/allContracts";
    }

    @GetMapping(value = "employee/editContract/{id}")
    public String editContract(@PathVariable("id") int id, Model model) {
        Contract contract = contractService.getEntityById(id);
        model.addAttribute("contract", contract);
        return "/employee/editContract";
    }
}
