package com.example.childhealthrecord.controller;

import com.example.childhealthrecord.entity.DiseaseEntity;
import com.example.childhealthrecord.entity.Symptom;
import com.example.childhealthrecord.model.DiseaseModel;
import com.example.childhealthrecord.service.DiseaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        List<DiseaseEntity> diseases = diseaseService.findAll();
        Symptom[] symptoms = Symptom.values();

        model.addAttribute("diseases", diseases);
        model.addAttribute("title", title);
        model.addAttribute("symptoms", symptoms);
        model.addAttribute("editedId", editedId);

        if(editedId != null) {
            model.addAttribute("editDisease", diseaseService.findById(editedId));
        }

        return "diseaseRegister";
    }

    @GetMapping("/create")
    public String create (Model model){
        DiseaseEntity newDisease = new DiseaseEntity();
        Symptom[] symptoms = Symptom.values();

        model.addAttribute("newDisease", newDisease);
        model.addAttribute("symptoms", symptoms);
        return "createDisease";
    }

    @PostMapping("/create")
    public String createAction(@Valid DiseaseModel newDisease, BindingResult result, Model model){

        if(result.hasErrors()){
            model.addAttribute(newDisease);
            model.addAttribute("org.springframework.validation.BindingResult.newDisease", result);
            return "createDisease";
        }

        diseaseService.saveDiseaseModelToEntity(newDisease);
        return "redirect:/diseaseRegister";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        diseaseService.deleteById(id);
        return "redirect:/diseaseRegister";
    }

    @PostMapping("/edit/{id}")
    public String edit(DiseaseEntity disease, @PathVariable Integer id) {
    DiseaseEntity existing = diseaseService.findById(id);

    existing.setName(disease.getName());
    existing.setStartingDate(disease.getStartingDate());
    existing.setEndingDate(disease.getEndingDate());
    existing.setSymptom1(disease.getSymptom1());
    existing.setSymptom2(disease.getSymptom2());
    existing.setSymptom3(disease.getSymptom3());

    diseaseService.save(existing);
    return "redirect:/diseaseRegister";
    }


}
