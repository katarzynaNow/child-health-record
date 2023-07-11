package com.example.childhealthrecord.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VaccinationController {
    @Value("${app.title.vaccination}")
    private String title;

    @GetMapping("/vaccination")
    public String diseaseRegisterPage(Model model){
        model.addAttribute("title", title);
        return "vaccination";
    }
}
