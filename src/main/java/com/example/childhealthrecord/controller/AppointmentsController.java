package com.example.childhealthrecord.controller;

import com.example.childhealthrecord.service.AppointmentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String diseaseRegisterPage(Model model){
        model.addAttribute("title", title);
        return "appointments";
    }
}
