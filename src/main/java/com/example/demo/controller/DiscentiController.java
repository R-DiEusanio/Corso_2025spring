package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DiscentiController {

    @GetMapping("/discenti-page")
    public String discentiPage() {
        return "discenti-list";
    }
}
