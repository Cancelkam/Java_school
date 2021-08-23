package com.javaSchool.eCare.controller;

import com.javaSchool.eCare.model.dto.Tariff.TariffViewForm;
import com.javaSchool.eCare.model.entity.Contract;
import com.javaSchool.eCare.model.entity.Option;
import com.javaSchool.eCare.model.entity.Tariff;
import com.javaSchool.eCare.service.api.OptionService;
import com.javaSchool.eCare.service.api.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class TariffsController {

    private final TariffService tariffService;
    private final OptionService optionService;

    @Autowired
    public TariffsController(TariffService tariffService, OptionService optionService) {
        this.tariffService = tariffService;
        this.optionService = optionService;
    }

    @ModelAttribute()
    public TariffViewForm tariffViewForm() {
        return new TariffViewForm();
    }

    @GetMapping(value = {"/index"})
    public String welcomePage() {
        return "index";
    }

    @GetMapping(value = "/employee/tariffs")
    public String getTariffs(Model model) {
        List<Tariff> tariffs = tariffService.findAll();
        List<TariffViewForm> tariffDto = new ArrayList<TariffViewForm>();
        for (Tariff tariff : tariffs) {
//           Iterator it = tariff.getContracts().iterator();
//            while (it.hasNext()) {
//                Contract s = (Contract) it.next();
//                System.out.println(s.getNumber());
//            }
            tariffDto.add(new TariffViewForm(tariff));
        }
        model.addAttribute("tariffs", tariffDto);
        return "/employee/tariffs";
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
    @GetMapping(value = {"employee/addTariff"})
    public String addTariffPage() {
        return "/employee/addTariff";
    }

    @PostMapping(value = "employee/addTariff")
    public String addTariff(@ModelAttribute("tariff") @Valid TariffViewForm tariffViewForm) {
        tariffService.createNewTariff(tariffViewForm);
        return "redirect:/employee/tariffs";
    }

//    @GetMapping(value = {"/deleteTariff"})
//    public String deleteTariff(@PathVariable("id") int id, Model model){
//        TariffViewForm tariffViewFormList = tariffService.getEntityById();
//        tariffService.deleteEntity(TariffViewForm );
//    }

    @GetMapping(value = "employee/editTariff/{id}")
    public String editTariff(@PathVariable("id") int id, Model model) {
        Tariff tariff = tariffService.getEntityById(id);
        List<Option> options = optionService.findAll();
        model.addAttribute("tariff", tariff);
        model.addAttribute("options", options);
        return "/employee/editTariff";
    }


    @PostMapping(value = "employee/editTariff/{id}")
    public String saveTariff(@PathVariable int id, @ModelAttribute("tariff") @Valid TariffViewForm tariffViewForm) {
        tariffViewForm.setIdTariff(id);
        tariffService.updateTariff(tariffViewForm);
        return "redirect:/employee/tariffs";
    }

    @GetMapping(value = "employee/tariffs/{id}/delete")
    public String deleteTariff(@PathVariable int id) {
        Tariff tariff = tariffService.getEntityById(id);
        tariffService.deleteEntity(tariff);
        return "redirect:/employee/tariffs";
    }
}
