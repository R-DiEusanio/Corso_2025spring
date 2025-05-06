package com.example.demo.controller;
import com.example.demo.entity.Docente;
import com.example.demo.entity.Studente;
import com.example.demo.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/studenti")
public class StudenteController {

    @Autowired
    StudenteService studenteService;

    @GetMapping
    public String redirectToLista() {return "redirect:/studenti/lista";}

    @GetMapping("/lista")
    public String list(Model model) {
        model.addAttribute("studenti" , studenteService.findAll());
        return "list-studenti";
    }

    @GetMapping("/nuovo")
    public String showAdd(Model model) {
        model.addAttribute("studente", new Studente());
        return "nuovo-studente";

    }

    @PostMapping
    public String create(@ModelAttribute("studente") Studente studente, BindingResult br) {
        if (br.hasErrors()) return "nuovo-studente";
        studenteService.save(studente);
        return "redirect:/studenti/lista";

    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model) {
        model.addAttribute("studente", studenteService.get(id));
        return "nuovo-studente";

    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable Long id, @ModelAttribute("studente") Studente studente, BindingResult br) {

        if (br.hasErrors()) return "nuovo-studente";
        studente.setId(id);
        studenteService.save(studente);
        return "redirect:/studenti/lista";

    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        studenteService.delete(id);
        return "redirect:/studenti/lista";

    }

    }



