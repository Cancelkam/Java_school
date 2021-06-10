package com.javaSchool.eCare.controller;

import com.javaSchool.eCare.model.dto.option.OptionViewForm;
import com.javaSchool.eCare.model.dto.user.UserAccountForm;
import com.javaSchool.eCare.model.entity.Option;
import com.javaSchool.eCare.model.entity.UserEntity;
import com.javaSchool.eCare.service.api.OptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OptionController {

    private final OptionService optionService;

    public OptionController(OptionService optionService) {
        this.optionService = optionService;
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
        OptionViewForm optionDto = new OptionViewForm(option);
        model.addAttribute("option", optionDto);
        return "/employee/editOption";
    }
}
