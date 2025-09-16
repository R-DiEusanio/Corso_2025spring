package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmailController {

    @GetMapping("/email-page")
    public String emailPage(){
        return "email";
    }
}
