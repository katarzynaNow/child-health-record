package com.example.childhealthrecord.controller;

import com.example.childhealthrecord.entity.VacStatus;
import com.example.childhealthrecord.entity.Vaccination;
import com.example.childhealthrecord.service.VaccinationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String vaccinationSchedulePage(Model model, @RequestParam(required = false) Integer editedId){
        List<Vaccination> vaccinations = vaccinationService.findAll();

        model.addAttribute("vaccinations", vaccinations);
        model.addAttribute("title", title);
        model.addAttribute("editedId", editedId);

        if(editedId != null) {
            model.addAttribute("editVaccination", vaccinationService.findById(editedId));
        }

        return "vaccination";
    }

    @GetMapping("/update")
    public String updateStatus(@RequestParam Integer id, @RequestParam VacStatus vacStatus){
        Vaccination existing = vaccinationService.findById(id);
        existing.setStatus(vacStatus);
        vaccinationService.save(existing);
        return "redirect:/vaccination";
    }

    @PostMapping("/edit/{id}")
    public String editNotes(String notes, @PathVariable Integer id) {
        Vaccination existing = vaccinationService.findById(id);
        existing.setNotes(notes);

        vaccinationService.save(existing);
        return "redirect:/vaccination";
    }
}
