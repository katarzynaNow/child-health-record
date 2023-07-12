package com.example.childhealthrecord.controller;

import com.example.childhealthrecord.model.Disease;
import com.example.childhealthrecord.service.DiseaseService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DiseaseRegisterController {

    @Value("${app.title.disease}")
    private String title;

    private final DiseaseService diseaseService;

    public DiseaseRegisterController(DiseaseService diseaseService) {
        this.diseaseService = diseaseService;
    }

    @GetMapping("/diseaseRegister")
    public String diseaseRegisterPage(Model model){
        List<Disease> diseases = diseaseService.findAll();

        model.addAttribute("diseases", diseases);
        model.addAttribute("title", title);
        return "diseaseRegister";
    }

    @GetMapping("/")
    public String showIndex(){
        return "redirect:diseaseRegister";
    }

    @GetMapping("/diseaseRegister/create")
    public String create (Model model){
        Disease newDisease = new Disease();
        model.addAttribute("newDisease", newDisease);
        return "createDisease";
    }

    @PostMapping("/diseaseRegister/create")
    public String createAction(Disease newDisease){
        newDisease.setId(null);
        diseaseService.save(newDisease);
        return "redirect:/diseaseRegister";
    }

    @GetMapping("/diseaseRegister/delete/{id}")
    public String delete(@PathVariable Integer id){
        diseaseService.deleteById(id);
        return "redirect:/diseaseRegister";
    }

    @PostMapping("/diseaseRegister/edit/{id}")
    public String edit(Disease disease, @PathVariable Integer id) {
    Disease existing = diseaseService.findById(id);
    existing.setName(disease.getName());
    existing.setDurationDays(disease.getDurationDays());
    existing.setSymptoms(disease.getSymptoms());
    diseaseService.save(existing);
    return "redirect:/diseaseRegister";
    }


}
