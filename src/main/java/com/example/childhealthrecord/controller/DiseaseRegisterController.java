package com.example.childhealthrecord.controller;

import com.example.childhealthrecord.model.Disease;
import com.example.childhealthrecord.model.Symptom;
import com.example.childhealthrecord.service.DiseaseService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/diseaseRegister")
public class DiseaseRegisterController {

    @Value("${app.title.disease}")
    private String title;

    private final DiseaseService diseaseService;

    public DiseaseRegisterController(DiseaseService diseaseService) {
        this.diseaseService = diseaseService;
    }

    @GetMapping
    public String diseaseRegisterPage(Model model, @RequestParam(required = false) Integer editedId){
        List<Disease> diseases = diseaseService.findAll();

        model.addAttribute("diseases", diseases);
        model.addAttribute("title", title);
        model.addAttribute("editedId", editedId);

        if(editedId != null) {
            model.addAttribute("editDisease", diseaseService.findById(editedId));
        }

        return "diseaseRegister";
    }

    @GetMapping("/create")
    public String create (Model model){
        Disease newDisease = new Disease();
        Symptom[] symptoms = Symptom.values();

        model.addAttribute("newDisease", newDisease);
        model.addAttribute("symptoms", symptoms);
        return "createDisease";
    }

    @PostMapping("/create")
    public String createAction(Disease newDisease){
        newDisease.setId(null);
        diseaseService.save(newDisease);
        return "redirect:/diseaseRegister";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        diseaseService.deleteById(id);
        return "redirect:/diseaseRegister";
    }

    @PostMapping("/edit/{id}")
    public String edit(Disease disease, @PathVariable Integer id) {
    Disease existing = diseaseService.findById(id);
    existing.setName(disease.getName());
    existing.setStartingDate(disease.getStartingDate());
    existing.setEndingDate(disease.getEndingDate());
    existing.setSymptom(disease.getSymptom());
    diseaseService.save(existing);
    return "redirect:/diseaseRegister";
    }


}
