package com.example.childhealthrecord.controller;

import com.example.childhealthrecord.model.VacStatus;
import com.example.childhealthrecord.model.Vaccination;
import com.example.childhealthrecord.service.VaccinationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/vaccination")
public class VaccinationController {
    @Value("${app.title.vaccination}")
    private String title;

    private final VaccinationService vaccinationService;

    public VaccinationController(VaccinationService vaccinationService) {
        this.vaccinationService = vaccinationService;
    }

    @GetMapping
    public String vaccinationSchedulePage(Model model){
        List<Vaccination> vaccinations = vaccinationService.findAll();

        model.addAttribute("vaccinations", vaccinations);
        model.addAttribute("title", title);
        return "vaccination";
    }

    @GetMapping("/update")
    public String updateStatus(@RequestParam Integer id, @RequestParam VacStatus status){
        Vaccination existing = vaccinationService.findById(id);
        existing.setStatus(status);
        vaccinationService.save(existing);
        return "redirect:/vaccination";
    }
}
