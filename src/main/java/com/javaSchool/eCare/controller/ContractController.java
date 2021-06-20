package com.javaSchool.eCare.controller;

import com.javaSchool.eCare.model.dto.contract.ContractViewForm;
import com.javaSchool.eCare.model.entity.Contract;
import com.javaSchool.eCare.model.entity.Option;
import com.javaSchool.eCare.model.entity.Tariff;
import com.javaSchool.eCare.service.api.ContractService;
import com.javaSchool.eCare.service.api.OptionService;
import com.javaSchool.eCare.service.api.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Set;

@Controller
public class ContractController {

    private final ContractService contractService;
    private final OptionService optionService;
    private final TariffService tariffService;

    @Autowired
    ContractController(ContractService contractService, OptionService optionService, TariffService tariffService) {
        this.contractService = contractService;
        this.optionService = optionService;
        this.tariffService = tariffService;
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
        List<Tariff> tariffs = tariffService.findAll();
        List<Option> options = optionService.findAll();
        model.addAttribute("contract", contract);
        model.addAttribute("tariffs", tariffs);
        model.addAttribute("options", options);
        return "/employee/editContract";
    }
    @GetMapping(value = "employee/editContract/{idContract}/addOption/{idOption}")
    public String addOptionToContract(@PathVariable("idContract") Integer idContract, @PathVariable("idOption") Integer idOption,  Model model){
        Contract contract = contractService.getEntityById(idContract);
        Option option = optionService.getEntityById(idOption);
        Set<Option> newOptionList = contract.getOptions();
        newOptionList.add(option);
        contract.setOptions(newOptionList);
        contractService.saveEntity(contract);

        return "redirect:/employee/editContract/" + idContract.toString();
    }
    @GetMapping(value = "employee/editContract/{idContract}/deleteOption/{idOption}")
    public String deleteOptionToContract(@PathVariable("idContract") Integer idContract, @PathVariable("idOption") Integer idOption,  Model model){
        Contract contract = contractService.getEntityById(idContract);
        Option option = optionService.getEntityById(idOption);
        Set<Option> newOptionList = contract.getOptions();
        newOptionList.remove(option);
        contract.setOptions(newOptionList);
        contractService.saveEntity(contract);
        return "redirect:/employee/editContract/" + idContract.toString();
    }

}
