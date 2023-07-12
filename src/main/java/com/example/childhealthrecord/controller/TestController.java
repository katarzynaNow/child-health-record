package com.example.childhealthrecord.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {

    @GetMapping("test")
    public String test(){
        return "Test";
    }

     @GetMapping("/")
    public String showIndex(){
        return "redirect:diseaseRegister";
    }
}
