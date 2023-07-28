package com.example.childhealthrecord.controller;

import com.example.childhealthrecord.service.AppointmentService;
import com.example.childhealthrecord.service.DiseaseService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatisticsController {
    @Value("${app.title.statistics}")
    private String title;

    private final AppointmentService appointmentService;

    private final DiseaseService diseaseService;

    public StatisticsController(AppointmentService appointmentService, DiseaseService diseaseService) {
        this.appointmentService = appointmentService;
        this.diseaseService = diseaseService;
    }

    @GetMapping("/statistics")
    public String statisticsPage(Model model){
        int sickDaysInYear = diseaseService.howManyDaysSick();
        int sickPercentage = Math.round((sickDaysInYear * 100)/360f);
        int[] data = {100-sickPercentage, sickPercentage};

        model.addAttribute("sickDaysInYear", sickDaysInYear );
        model.addAttribute("sickPercentage",Math.round(sickPercentage));
        model.addAttribute("data", data);
        model.addAttribute("antibiotics", appointmentService.howManyAntibiotics());
        model.addAttribute("title", title);
        return "statistics";
    }
}
