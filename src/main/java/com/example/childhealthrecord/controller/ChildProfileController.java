package com.example.childhealthrecord.controller;

import com.example.childhealthrecord.dto.ChildProfileDto;
import com.example.childhealthrecord.entity.ChildProfileEntity;
import com.example.childhealthrecord.service.AppointmentService;
import com.example.childhealthrecord.service.ChildProfileService;
import com.example.childhealthrecord.service.DiseaseService;
import com.example.childhealthrecord.service.VaccinationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/profiles")
public class ChildProfileController {

    @Value("${app.title.profiles}")
    private String title;

    private final ChildProfileService childProfileService;
    private final DiseaseService diseaseService;

    private final AppointmentService appointmentService;

    private final VaccinationService vaccinationService;

    public ChildProfileController(ChildProfileService childProfileService, DiseaseService diseaseService, AppointmentService appointmentService, VaccinationService vaccinationService) {
        this.childProfileService = childProfileService;
        this.diseaseService = diseaseService;
        this.appointmentService = appointmentService;
        this.vaccinationService = vaccinationService;
    }

    @GetMapping
    public String profilesList(Model model, @RequestParam(required = false) Integer editedId){
        model.addAttribute("title", title);
        model.addAttribute("profiles", childProfileService.findAll());

        if(editedId != null) {
            model.addAttribute("editProfile", childProfileService.findById(editedId));
        }

        return "profiles";
    }

    @GetMapping("/create")
    public String create(Model model){
        ChildProfileEntity newProfile = new ChildProfileEntity();
        model.addAttribute("newProfile", newProfile);
        return "createProfile";
    }

    @PostMapping("/create")
    public String createAction(ChildProfileDto childProfile, @RequestParam("file") MultipartFile file) throws IOException{
        childProfile.setPicture(file.getBytes());
        ChildProfileEntity childProfileEntity= childProfileService.saveChildProfileDtoToEntity(childProfile);
        return "redirect:/profiles";
    }

    @GetMapping(value = "/file/{id}", produces = "image/*")
    @ResponseBody
    public byte[] picture(@PathVariable Integer id){
        return childProfileService.findById(id)
                .getPicture();
    }

 /*   @GetMapping("/view/{profileId}/diseaseRegister")
    public String view (Model model, @PathVariable Integer profileId){
        model.addAttribute("profile", childProfileService.findById(profileId));
        return "diseaseRegister";
    }*/

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        childProfileService.deleteById(id);
        return "redirect:/profiles";
    }

  /*  @PostMapping("edit/{id}")
    public String edit(ChildProfile profile, @PathVariable Integer id){
        ChildProfile existing = childProfileService.findById(id);

        existing.setName(profile.getName());
        existing.setBirthDate(profile.getBirthDate());
        existing.setPicture(profile.getPicture());

        childProfileService.save(existing);
        return "redirect:/profiles";
    }*/

}
