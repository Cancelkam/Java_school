package com.javaSchool.eCare.controller;

import com.javaSchool.eCare.model.dto.Tariff.TariffViewForm;
import com.javaSchool.eCare.model.entity.Tariff;
import com.javaSchool.eCare.service.api.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TariffsController {

    private final TariffService tariffService;

    @Autowired
    public TariffsController(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @GetMapping(value = {"/index"})
    public String loginPage(@RequestParam(required = false) String index, Model model) {
        model.addAttribute("index", index);
        return "index";
    }


    @GetMapping(value = "/tariffs")
    public String getTariffs(@RequestParam(required = false) List tariffs, Model model) {
        tariffs = tariffService.findAll();
        model.addAttribute("tariffs", tariffs);
        return "tariffs";
    }

    @ModelAttribute("tariff")
    public TariffViewForm tariffViewForm() {
        return new TariffViewForm();
    }

    @ModelAttribute("tariffs")
    public List<Tariff> tariffViewForms() {
        return tariffService.findAll();
    }

}
