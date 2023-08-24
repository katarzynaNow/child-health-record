package com.example.childhealthrecord.controller;

import com.example.childhealthrecord.service.AppointmentService;
import com.example.childhealthrecord.service.ChildProfileService;
import com.example.childhealthrecord.service.DiseaseService;
import com.example.childhealthrecord.service.VaccinationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;

@Controller
public class StatisticsController {
    @Value("${app.title.statistics}")
    private String title;

    private final AppointmentService appointmentService;
    private final DiseaseService diseaseService;
    private final VaccinationService vaccinationService;
    private final ChildProfileService childProfileService;

    public StatisticsController(AppointmentService appointmentService, DiseaseService diseaseService, VaccinationService vaccinationService, ChildProfileService childProfileService) {
        this.appointmentService = appointmentService;
        this.diseaseService = diseaseService;
        this.vaccinationService = vaccinationService;
        this.childProfileService = childProfileService;
    }

    @GetMapping("/profiles/{profileId}/statistics")
    public String statisticsPage(Model model, @PathVariable Integer profileId){
        LocalDate currentDate = LocalDate.now();

        int[] sickDaysEveryMonthData = diseaseService.daysInMonthsSick(profileId);
        int sickDaysInYear = diseaseService.sickDaysInYear(sickDaysEveryMonthData);
        int sickPercentage = diseaseService.sickDaysPercentage(sickDaysInYear) ;
        int[] data = {100-sickPercentage, sickPercentage};

        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        model.addAttribute("title", title);
        model.addAttribute("currentDate", currentDate);

        model.addAttribute("sickDaysInYear", sickDaysInYear );
        model.addAttribute("sickPercentage",sickPercentage);
        model.addAttribute("data", data);

        model.addAttribute("antibiotics", appointmentService.howManyAntibiotics(profileId));

        model.addAttribute("monthsLabels", months);
        model.addAttribute("sickDaysEveryMonthData", sickDaysEveryMonthData );

        model.addAttribute("mandatoryVac", vaccinationService.howManyMandatoryVaccinations(profileId));
        model.addAttribute("recommendedVac", vaccinationService.howManyRecommendedVaccinations(profileId));

        model.addAttribute("profile", childProfileService.findById(profileId));

        return "statistics";
    }
}
