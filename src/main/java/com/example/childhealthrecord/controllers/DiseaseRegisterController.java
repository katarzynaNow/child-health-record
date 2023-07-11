package com.example.childhealthrecord.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DiseaseRegisterController {

    @Value("${app.title.disease}")
    private String title;

    @GetMapping("/diseaseRegister")
    public String diseaseRegisterPage(Model model){
        model.addAttribute("title", title);
        return "diseaseRegister";
    }

    @GetMapping("/")
    public String showIndex(){
        return "redirect:diseaseRegister";
    }
}
