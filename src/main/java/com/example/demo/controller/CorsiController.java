package com.example.demo.controller;
import com.example.demo.entity.Corsi;
import com.example.demo.service.CorsiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.example.demo.service.DocenteService;


@Controller
@RequestMapping("/corsi")
public class CorsiController {

    @Autowired
    CorsiService corsiService;
    DocenteService docenteService;

    @GetMapping
    public ModelAndView redirectToLista() {
        return new ModelAndView("redirect:/corsi/lista");
    }

    @GetMapping("/lista")
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("list-corsi");
        mav.addObject("corsi", corsiService.findAll());
        return mav;
    }

    @GetMapping("/nuovo")
    public ModelAndView showAdd() {
        ModelAndView mav = new ModelAndView("nuovo-corso");
        mav.addObject("corso", new Corsi());
        mav.addObject("docenti", docenteService.findAll());
        return mav;
    }

    @PostMapping
    public ModelAndView create(@ModelAttribute("corso") Corsi corsi, BindingResult br) {
        if (br.hasErrors()) {
            return new ModelAndView("nuovo-corso");
        }
        corsiService.save(corsi);
        return new ModelAndView("redirect:/corsi/lista");
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEdit(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("nuovo-corso");
        mav.addObject("corso", corsiService.get(id));
        return mav;
    }

    @PostMapping("/{id}/edit")
    public ModelAndView update(@PathVariable Long id, @ModelAttribute("corso") Corsi corsi, BindingResult br) {
        if (br.hasErrors()) {
            return new ModelAndView("nuovo-corso");
        }

        corsi.setId(id);
        corsiService.save(corsi);
        return new ModelAndView("redirect:/corsi/lista");
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable Long id) {
        corsiService.delete(id);
        return new ModelAndView("redirect:/corsi/lista");
    }

}








