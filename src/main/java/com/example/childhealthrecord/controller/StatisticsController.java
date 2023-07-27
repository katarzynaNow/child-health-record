package com.example.childhealthrecord.controller;

import com.example.childhealthrecord.service.AppointmentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatisticsController {
    @Value("${app.title.statistics}")
    private String title;

    private final AppointmentService appointmentService;

    public StatisticsController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/statistics")
    public String statisticsPage(Model model){

        model.addAttribute("antibiotics", appointmentService.howManyAntibiotics());
        model.addAttribute("title", title);
        return "statistics";
    }
}
