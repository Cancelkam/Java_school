package com.javaSchool.eCare.controller;

import com.javaSchool.eCare.model.dto.Tariff.TariffViewForm;
import com.javaSchool.eCare.model.entity.Tariff;
import com.javaSchool.eCare.service.api.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TariffsController {

    private final TariffService tariffService;

    @Autowired
    public TariffsController(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @ModelAttribute("tariff")
    public TariffViewForm tariffViewForm() {
        return new TariffViewForm();
    }

    @GetMapping(value = {"/index"})
    public String loginPage(@RequestParam(required = false) String index, Model model) {
        model.addAttribute("index", index);
        return "index";
    }


    @GetMapping(value = "/tariffs")
    public String getTariffs(Model model) {
        List<Tariff> tariffs = tariffService.findAll();
        List<TariffViewForm> tariffDto = new ArrayList<TariffViewForm>();
        for (Tariff tariff : tariffs) {
            tariffDto.add(new TariffViewForm(tariff));
        }
        model.addAttribute("tariffs", tariffDto);
        return "tariffs";
    }


//
//    @ModelAttribute("tariffs")
//    public List<Tariff> tariffViewForms() {
//        return tariffService.findAll();
//    }

}
