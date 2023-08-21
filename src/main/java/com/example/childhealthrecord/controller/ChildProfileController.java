package com.example.childhealthrecord.controller;

import com.example.childhealthrecord.entity.ChildProfile;
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
    public String profilesList(Model model){
        model.addAttribute("title", title);
        model.addAttribute("profiles", childProfileService.findAll());
        return "profiles";
    }

    @GetMapping("/create")
    public String create(Model model){
        ChildProfile newProfile = new ChildProfile();
        model.addAttribute("newProfile", newProfile);
        return "createProfile";
    }

    @PostMapping("/create")
    public String createAction(ChildProfile childProfile, @RequestParam("file") MultipartFile file) throws IOException{
        childProfile.setPicture(file.getBytes());
        childProfileService.save(childProfile);
        return "redirect:/profiles";
    }

    @GetMapping(value = "/file/{id}", produces = "image/*")
    @ResponseBody
    public byte[] picture(@PathVariable Integer id){
        return childProfileService.findById(id)
                .getPicture();
    }

    @GetMapping("/view/{id}")
    public String view (Model model, @PathVariable Integer id){
        model.addAttribute("profile", childProfileService.findById(id));
        return "diseaseRegister";
    }
}
