package com.example.childhealthrecord.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatisticsController {
    @Value("${app.title.statistics}")
    private String title;

    @GetMapping("/statistics")
    public String statisticsPage(Model model){
        model.addAttribute("title", title);
        return "statistics";
    }
}
