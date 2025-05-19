package com.example.demo.controller;
import com.example.demo.data.dto.DiscenteDTO;
import com.example.demo.data.dto.DocenteDTO;
import com.example.demo.entity.Discente;
import com.example.demo.entity.Docente;
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
        List<DiscenteDTO> lista = discenteService.findAll();
        ModelAndView mav = new ModelAndView("list-discenti");
        mav.addObject("discenti",lista);
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

    @GetMapping("/ordinati")
    public ModelAndView mostraDiscentiOrdinatiPerNome() {
        List<DiscenteDTO> lista = discenteService.DiscentiOrdinatiPerNome();
        ModelAndView mav = new ModelAndView("list-discenti");
        mav.addObject("discenti", lista);
        return mav;

    }

    }



