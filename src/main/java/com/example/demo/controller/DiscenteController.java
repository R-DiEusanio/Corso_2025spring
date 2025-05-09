package com.example.demo.controller;
import com.example.demo.entity.Discente;
import com.example.demo.service.DiscenteService;
import com.example.demo.service.CorsiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/discenti")
public class DiscenteController {

    @Autowired
    DiscenteService discenteService;

    @Autowired
    CorsiService corsiService;

    @GetMapping
    public ModelAndView redirectToLista() {
        return new ModelAndView("redirect:/discenti/lista");
    }

    @GetMapping("/lista")
    public ModelAndView list(){
        ModelAndView mav = new ModelAndView("list-discenti");
        mav.addObject("discenti", discenteService.findAll());
        return mav;

    }


    @GetMapping("/nuovo")
    public ModelAndView showAdd() {
        ModelAndView mav = new ModelAndView("nuovo-discente");
        mav.addObject("discente", new Discente());
        mav.addObject("listaCorsi", corsiService.findAll());
        return mav;
    }


    @PostMapping
    public ModelAndView create(@ModelAttribute("discente") Discente discente, BindingResult br) {
        if (br.hasErrors()) {
            return new ModelAndView("nuovo-discente");
        }
        discenteService.save(discente);
        return new ModelAndView("redirect:/discenti/lista");

    }


    @GetMapping("/{id}/edit")
    public ModelAndView showEdit(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("nuovo-discente");
        mav.addObject("discente", discenteService.get(id));
        mav.addObject("listaCorsi", corsiService.findAll());
        return mav;
    }

    @PostMapping("/{id}/edit")
    public ModelAndView update(@PathVariable Long id, @ModelAttribute("discente") Discente discente, BindingResult br) {
    if (br.hasErrors()) {
        return new ModelAndView("nuovo-discente");
    }
    discente.setId(id);
    discenteService.save(discente);
    return new ModelAndView("redirect:/discenti/lista");

    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable Long id) {
        discenteService.delete(id);
        return new ModelAndView("redirect:/discenti/lista");
    }

    @GetMapping("/maggiorenni")
    public ModelAndView mostraMaggiorenni() {
        List<Discente> lista = discenteService.maggiorenni();
        ModelAndView mv = new ModelAndView("maggiorenni");
        mv.addObject("discenti", lista);
        return mv;
    }

    @GetMapping("/citta/{nomeCitta}")
    public ModelAndView mostraDiscentiPerCitta(@PathVariable String nomeCitta) {
        List<Discente> lista = discenteService.residenza(nomeCitta);
        ModelAndView mav = new ModelAndView("list-discenti");
        mav.addObject("discenti", lista);
        return mav;
    }

    @GetMapping("/ordinati")
    public ModelAndView mostraDiscentiOrdinatiPerNome() {
        List<Discente> lista = discenteService.DiscentiOrdinatiPerNome();
        ModelAndView mav = new ModelAndView("list-discenti");
        mav.addObject("discenti", lista);
        return mav;
    }

    }



