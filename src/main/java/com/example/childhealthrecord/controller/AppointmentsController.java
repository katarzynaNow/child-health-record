package com.example.childhealthrecord.controller;

import com.example.childhealthrecord.model.Antibiotic;
import com.example.childhealthrecord.model.Appointment;
import com.example.childhealthrecord.service.AppointmentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/appointments")
public class AppointmentsController {
    @Value("${app.title.appointments}")
    private String title;

    private final AppointmentService appointmentService;

    public AppointmentsController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public String appointmentsPage(Model model, @RequestParam(required = false) Integer editedId){
        List<Appointment> appointments = appointmentService.findAll();

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
        Appointment newAppointment = new Appointment();
        Antibiotic[] antibiotics = Antibiotic.values();

        model.addAttribute("newAppointment", newAppointment);
        model.addAttribute("antibiotics", antibiotics);

        return "createAppointment";
     }

     @PostMapping("/create")
    public String createAction(Appointment newAppointment){
        newAppointment.setId(null);
        appointmentService.save(newAppointment);

        return "redirect:/appointments";
     }

     @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        appointmentService.deleteById(id);

         return "redirect:/appointments";
     }

     @PostMapping("/edit/{id}")
     public String edit( Appointment appointment, @PathVariable Integer id){
        Appointment existing = appointmentService.findById(id);

        existing.setDate(appointment.getDate());
        existing.setDiagnosis(appointment.getDiagnosis());
        existing.setMedicines(appointment.getMedicines());
        existing.setAntibiotic(appointment.getAntibiotic());
        existing.setNotes(appointment.getNotes());

        appointmentService.save(existing);

         return "redirect:/appointments";
     }

}
