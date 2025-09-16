package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompetenzaController {
    @GetMapping("/competenze-page")
    public String competenzePage() {
        return "competenze"; // templates/competenze.html
    }
}