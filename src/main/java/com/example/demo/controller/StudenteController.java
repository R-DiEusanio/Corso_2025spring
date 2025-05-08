package com.example.demo.controller;
import com.example.demo.entity.Studente;
import com.example.demo.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/studenti")
public class StudenteController {

    @Autowired
    StudenteService studenteService;

    @GetMapping
    public ModelAndView redirectToLista() {
        return new ModelAndView("redirect:/studenti/lista");
    }

    @GetMapping("/lista")
    public ModelAndView list(){
        ModelAndView mav = new ModelAndView("list-studenti");
        mav.addObject("studenti", studenteService.findAll());
        return mav;

    }

    @GetMapping("/nuovo")
    public ModelAndView showAdd() {

        ModelAndView mav = new ModelAndView("nuovo-studente");
        mav.addObject("studente", new Object());
        return mav;

    }

    @PostMapping
    public ModelAndView create(@ModelAttribute("studente") Studente studente, BindingResult br) {
        if (br.hasErrors()) {
            return new ModelAndView("nuovo-studente");
        }
        studenteService.save(studente);
        return new ModelAndView("redirect:/studenti/lista");

    }


    @GetMapping("/{id}/edit")
    public ModelAndView showEdit(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("nuovo-studente");
        mav.addObject("studente", studenteService.get(id));
        return mav;

    }

    @PostMapping("/{id}/edit")
    public ModelAndView update(@PathVariable Long id, @ModelAttribute("studente") Studente studente, BindingResult br) {
    if (br.hasErrors()) {
        return new ModelAndView("nuovo-studente");
    }
    studente.setId(id);
    studenteService.save(studente);
    return new ModelAndView("redirect:/studenti/lista");

    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable Long id) {
        studenteService.delete(id);
        return new ModelAndView("redirect:/studenti/lista");
    }

    @GetMapping("/maggiorenni")
    public ModelAndView mostraMaggiorenni() {
        List<Studente> lista = studenteService.maggiorenni();
        ModelAndView mv = new ModelAndView("maggiorenni");
        mv.addObject("studenti", lista);
        return mv;
    }

    @GetMapping("/citta/{nomeCitta}")
    public ModelAndView mostraStudentiPerCitta(@PathVariable String nomeCitta) {
        List<Studente> lista = studenteService.residenza(nomeCitta);
        ModelAndView mav = new ModelAndView("list-studenti");
        mav.addObject("studenti", lista);
        return mav;
    }

    @GetMapping("/ordinati")
    public ModelAndView mostraStudentiOrdinatiPerNome() {
        List<Studente> lista = studenteService.StudentiOrdinatiPerNome();
        ModelAndView mav = new ModelAndView("list-studenti");
        mav.addObject("studenti", lista);
        return mav;
    }

    }



