package com.javaSchool.eCare.controller;

import com.javaSchool.eCare.model.dto.Tariff.TariffViewForm;
import com.javaSchool.eCare.model.dto.option.OptionViewForm;
import com.javaSchool.eCare.model.dto.user.UserAccountForm;
import com.javaSchool.eCare.model.entity.Option;
import com.javaSchool.eCare.model.entity.Tariff;
import com.javaSchool.eCare.model.entity.UserEntity;
import com.javaSchool.eCare.service.api.OptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OptionController {

    private final OptionService optionService;

    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @ModelAttribute()
    public OptionViewForm optionViewForm () {
        return new OptionViewForm();
    }

    @GetMapping(value = "employee/allOptions")
    public String getOptions(Model model) {
        List<Option> options = optionService.findAll();
        List<OptionViewForm> optionDto = new ArrayList<OptionViewForm>();
        for (Option option : options) {
            optionDto.add(new OptionViewForm(option));
        }
        model.addAttribute("options", optionDto);
        return "/employee/allOptions";
    }

    @GetMapping(value = "employee/editOption/{id}")
    public String editOption(@PathVariable("id") int id, Model model){
        Option option = optionService.getEntityById(id);
        model.addAttribute("option", option);
        return "/employee/editOption";
    }

    @PostMapping(value = "employee/editOption/{id}")
    public String saveOption(@PathVariable int id, @ModelAttribute("option") @Valid OptionViewForm optionViewForm) {
        optionViewForm.setIdOption(id);
        optionService.updateOption(optionViewForm);
        return "redirect:/employee/allOptions";
    }

    @GetMapping(value = {"employee/addOption"})
    public String addOptionPage() {
        return "/employee/addOption";
    }

    @PostMapping(value = "employee/addOption")
    public String addOption(@ModelAttribute("option") @Valid OptionViewForm optionViewForm) {
        optionService.createNewOption(optionViewForm);
        return "redirect:/employee/allOptions";
    }

    @GetMapping(value = "employee/editOption/{id}/delete")
    public String deleteOption(@PathVariable int id) {
        Option option = optionService.getEntityById(id);
        optionService.deleteEntity(option);
        return "redirect:/employee/allOptions";
    }

}
