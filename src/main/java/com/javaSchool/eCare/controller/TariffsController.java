package com.javaSchool.eCare.controller;

import com.javaSchool.eCare.service.api.TariffService;
import com.javaSchool.eCare.service.implementation.TariffServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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


    @RequestMapping(value = "/tariffs", method = RequestMethod.GET)
    public String getTariffs(@RequestParam(required = false) List tariff, Model model) {
        tariff = tariffService.findAll();
        model.addAttribute("tariffs", tariff);
        return "tariffs";

    }

}
