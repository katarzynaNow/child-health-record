package com.example.childhealthrecord.controller;

import com.example.childhealthrecord.service.AppointmentService;
import com.example.childhealthrecord.service.DiseaseService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.Map;

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
        LocalDate currentDate = LocalDate.now();

        int[] sickDaysEveryMonthData = diseaseService.daysInMonthsSick();
        int sickDaysInYear = diseaseService.sickDaysInYear(sickDaysEveryMonthData);
        int sickPercentage = diseaseService.sickDaysPercentage(sickDaysInYear) ;
        int[] data = {100-sickPercentage, sickPercentage};

        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        model.addAttribute("title", title);
        model.addAttribute("currentDate", currentDate);

        model.addAttribute("sickDaysInYear", sickDaysInYear );
        model.addAttribute("sickPercentage",sickPercentage);
        model.addAttribute("data", data);

        model.addAttribute("antibiotics", appointmentService.howManyAntibiotics());

        model.addAttribute("monthsLabels", months);
        model.addAttribute("sickDaysEveryMonthData", sickDaysEveryMonthData );

        return "statistics";
    }
}
