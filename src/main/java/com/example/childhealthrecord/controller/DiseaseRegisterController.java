package com.example.childhealthrecord.controller;

import com.example.childhealthrecord.entity.DiseaseEntity;
import com.example.childhealthrecord.entity.Symptom;
import com.example.childhealthrecord.dto.DiseaseDto;
import com.example.childhealthrecord.service.ChildProfileService;
import com.example.childhealthrecord.service.DiseaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/profiles/{profileId}/diseaseRegister")
public class DiseaseRegisterController {

    @Value("${app.title.disease}")
    private String title;

    private final DiseaseService diseaseService;
    private final ChildProfileService childProfileService;

    public DiseaseRegisterController(DiseaseService diseaseService, ChildProfileService childProfileService) {
        this.diseaseService = diseaseService;
        this.childProfileService = childProfileService;
    }

    @GetMapping
    public String diseaseRegisterPage(Model model,@PathVariable Integer profileId,
                                      @RequestParam(required = false) Integer editedId){
        List<DiseaseEntity> diseases = diseaseService.findAll();
        Symptom[] symptoms = Symptom.values();

        model.addAttribute("diseases", diseases);
        model.addAttribute("title", title);
        model.addAttribute("symptoms", symptoms);
        model.addAttribute("editedId", editedId);
        model.addAttribute("profileId", profileId);
        model.addAttribute("profile", childProfileService.findById(profileId));

        if(editedId != null) {
            model.addAttribute("editDisease", diseaseService.findById(editedId));
        }

        return "diseaseRegister";
    }

    @GetMapping("/create")
    public String create (Model model, @PathVariable Integer profileId){
        DiseaseEntity newDisease = new DiseaseEntity();
        Symptom[] symptoms = Symptom.values();

        model.addAttribute("newDisease", newDisease);
        model.addAttribute("symptoms", symptoms);
        model.addAttribute("profile", childProfileService.findById(profileId));
        return "createDisease";
    }

    @PostMapping("/create")
    public String createAction(@Valid DiseaseDto newDisease, BindingResult result, Model model,
                               @PathVariable Integer profileId){

        model.addAttribute("profileId", profileId);

        if(result.hasErrors()){
            model.addAttribute(newDisease);
            model.addAttribute("org.springframework.validation.BindingResult.newDisease", result);

            Symptom[] symptoms = Symptom.values();
            model.addAttribute("symptoms", symptoms);

            return "createDisease";
        }

        DiseaseEntity disease= diseaseService.saveDiseaseModelToEntity(newDisease);
        disease.setChild(childProfileService.findById(profileId));
        diseaseService.save(disease);
        return "redirect:/profiles/{profileId}/diseaseRegister";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        diseaseService.deleteById(id);
        return "redirect:/profiles/{profileId}/diseaseRegister";
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
    return "redirect:/profiles/{profileId}/diseaseRegister";
    }
}
