package com.example.childhealthrecord.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppointmentsController {
    @Value("${app.title.appointments}")
    private String title;

    @GetMapping("/appointments")
    public String diseaseRegisterPage(Model model){
        model.addAttribute("title", title);
        return "appointments";
    }
}
