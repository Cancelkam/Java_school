package com.javaSchool.eCare.controller;

import com.javaSchool.eCare.model.dto.Tariff.TariffViewForm;
import com.javaSchool.eCare.model.entity.Tariff;
import com.javaSchool.eCare.service.api.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TariffsController {

    private final TariffService tariffService;

    @Autowired
    public TariffsController(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @ModelAttribute()
    public TariffViewForm tariffViewForm() {
        return new TariffViewForm();
    }

    @GetMapping(value = {"/index"})
    public String welcomePage() {
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

    //    @GetMapping("/tariff/{id}")
//    public String findTariffId(@PathVariable("id") int id, Model model) {
//        List<TariffViewForm> tariffViewFormList = tariffService.getEntityById(id);
//        model.addAttribute("tariffViewFormList", tariffViewFormList);
//        return "employee/tariff";
//    }
//
//    @GetMapping("/add/{id}")
//    public String createNewTariff(@PathVariable("id") int id, Model model) {
//        TariffViewForm tariffViewForm = tariffService.createNewTariff(TariffViewForm id);
//        model.addAttribute("tariff", tariffViewForm);
//        return "employee/addTariff";
//    }
//
    @GetMapping(value = {"/addTariff"})
    public String addTariffPage() {
        return "employee/addTariff";
    }

    @PostMapping(value = "/add")
    public String addTariff(@ModelAttribute("tariff") @Valid TariffViewForm tariffViewForm) {
        tariffService.createNewTariff(tariffViewForm);
        return "redirect:tariffs";
    }

//    @GetMapping(value = {"/deleteTariff"})
//    public String deleteTariff(@PathVariable("id") int id, Model model){
//        TariffViewForm tariffViewFormList = tariffService.getEntityById();
//        tariffService.deleteEntity(TariffViewForm );
//    }

    @GetMapping(value = {"/editTariff/{id}"})
    public String editTariff(@PathVariable("id") int id, Model model){
       Tariff tariff = tariffService.getEntityById(id);
        model.addAttribute("tariff", tariff);
        return "employee/editTariff";
    }


//    @PostMapping(value = "/editTariff/{id}")
//    public String saveTariff(Model model, @PathVariable int id) {
//
//        return "redirect:tariffs";
//    }

}
