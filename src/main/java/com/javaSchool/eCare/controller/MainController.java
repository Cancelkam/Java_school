package com.javaSchool.eCare.controller;

//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//public class MainController {
//    /**
//     * Go to index page.
//     */
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ModelAndView indexPage() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("index");
//        return modelAndView;
//    }
//}


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = {"/"})
    public String welcomePage(Model model) {

        model.addAttribute("example", "example message");

        return "/index";
    }
}