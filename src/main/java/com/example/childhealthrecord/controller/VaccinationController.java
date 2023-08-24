package com.example.childhealthrecord.controller;

import com.example.childhealthrecord.entity.VacStatus;
import com.example.childhealthrecord.entity.Vaccination;
import com.example.childhealthrecord.service.ChildProfileService;
import com.example.childhealthrecord.service.VaccinationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/profiles/{profileId}/vaccination")
public class VaccinationController {
    @Value("${app.title.vaccination}")
    private String title;

    private final VaccinationService vaccinationService;
    private final ChildProfileService childProfileService;

    public VaccinationController(VaccinationService vaccinationService, ChildProfileService childProfileService) {
        this.vaccinationService = vaccinationService;
        this.childProfileService = childProfileService;
    }

    @GetMapping
    public String vaccinationSchedulePage(Model model, @RequestParam(required = false) Integer editedId,
                                          @PathVariable Integer profileId){
        List<Vaccination> vaccinations = vaccinationService.findAll();

        model.addAttribute("vaccinations", vaccinations);
        model.addAttribute("title", title);
        model.addAttribute("editedId", editedId);
        model.addAttribute("profile", childProfileService.findById(profileId));


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
        return "redirect:/profiles/{profileId}/vaccination";
    }

    @PostMapping("/edit/{id}")
    public String editNotes(String notes, @PathVariable Integer id) {
        Vaccination existing = vaccinationService.findById(id);
        existing.setNotes(notes);

        vaccinationService.save(existing);
        return "redirect:/profiles/{profileId}/vaccination";
    }
}
