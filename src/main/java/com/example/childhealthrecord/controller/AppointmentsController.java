package com.example.childhealthrecord.controller;

import com.example.childhealthrecord.entity.AppointmentEntity;
import com.example.childhealthrecord.dto.AppointmentDto;
import com.example.childhealthrecord.service.AppointmentService;
import com.example.childhealthrecord.service.DiseaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/appointments")
public class AppointmentsController {
    @Value("${app.title.appointments}")
    private String title;

    private final AppointmentService appointmentService;
    private final DiseaseService diseaseService;

    public AppointmentsController(AppointmentService appointmentService, DiseaseService diseaseService) {
        this.appointmentService = appointmentService;
        this.diseaseService = diseaseService;
    }

    @GetMapping
    public String appointmentsPage(Model model, @RequestParam(required = false) Integer editedId){
        List<AppointmentEntity> appointments = appointmentService.findAll();

        model.addAttribute("title", title);
        model.addAttribute("appointments", appointments);
        model.addAttribute("editedId", editedId);

        if(editedId != null){
            model.addAttribute("editAppointment", appointmentService.findById(editedId));
        }

        return "appointments";
    }

    @GetMapping("/create")
    public String create (Model model){
        AppointmentEntity newAppointment = new AppointmentEntity();

        model.addAttribute("newAppointment", newAppointment);
        model.addAttribute("diseasesId", diseaseService.diseasesIdList());

        return "createAppointment";
     }

     @PostMapping("/create")
    public String createAction(@Valid AppointmentDto newAppointment, BindingResult result, Model model){

         if(result.hasErrors()){
             model.addAttribute(newAppointment);
             model.addAttribute("org.springframework.validation.BindingResult.newAppointment", result);

             model.addAttribute("diseasesId", diseaseService.diseasesIdList());

             return "createAppointment";
         }

        appointmentService.saveAppointmentModelToEntity(newAppointment);

        return "redirect:/appointments";
     }

     @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        appointmentService.deleteById(id);

         return "redirect:/appointments";
     }

     @PostMapping("/edit/{id}")
     public String edit(AppointmentEntity appointment, @PathVariable Integer id){
        AppointmentEntity existing = appointmentService.findById(id);

        existing.setDate(appointment.getDate());
        existing.setDiagnosis(appointment.getDiagnosis());
        existing.setMedicines(appointment.getMedicines());
        existing.setAntibiotic(appointment.isAntibiotic());
        existing.setNotes(appointment.getNotes());
        existing.setDisease(appointment.getDisease());

        appointmentService.save(existing);

        return "redirect:/appointments";
     }
}
