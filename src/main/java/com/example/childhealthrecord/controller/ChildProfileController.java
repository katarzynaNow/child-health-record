package com.example.childhealthrecord.controller;

import com.example.childhealthrecord.dto.ChildProfileDto;
import com.example.childhealthrecord.entity.ChildProfileEntity;
import com.example.childhealthrecord.service.AppointmentService;
import com.example.childhealthrecord.service.ChildProfileService;
import com.example.childhealthrecord.service.DiseaseService;
import com.example.childhealthrecord.service.VaccinationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/profiles")
public class ChildProfileController {

    @Value("${app.title.profiles}")
    private String title;

    private final ChildProfileService childProfileService;

    public ChildProfileController(ChildProfileService childProfileService) {
        this.childProfileService = childProfileService;
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
    public String createAction(@Valid ChildProfileDto newProfile, BindingResult result, Model model,
                               @RequestParam("file") MultipartFile file) throws IOException{

        if(result.hasErrors()){
            model.addAttribute(newProfile);
            model.addAttribute("org.springframework.validation.BindingResult.newProfile", result);

            return "createProfile";
        }

        childProfileService.saveChildProfileDtoToEntity(newProfile, file);
        return "redirect:/profiles";
    }

    @GetMapping(value = "/file/{id}", produces = "image/*")
    @ResponseBody
    public byte[] picture(@PathVariable Integer id){
        return childProfileService.findById(id)
                .getPicture();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        childProfileService.deleteById(id);
        return "redirect:/profiles";
    }
}
