package com.example.childhealthrecord.controller;

import com.example.childhealthrecord.model.Vaccination;
import com.example.childhealthrecord.service.VaccinationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class VaccinationController {
    @Value("${app.title.vaccination}")
    private String title;

    private final VaccinationService vaccinationService;

    public VaccinationController(VaccinationService vaccinationService) {
        this.vaccinationService = vaccinationService;
    }

    @GetMapping("/vaccination")
    public String vaccinationSchedulePage(Model model){
        List<Vaccination> vaccinations = vaccinationService.findAll();

        model.addAttribute("vaccinations", vaccinations);
        model.addAttribute("title", title);
        return "vaccination";
    }
}
