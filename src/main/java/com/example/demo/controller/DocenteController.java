package com.example.demo.controller;
import com.example.demo.entity.Docente;
import com.example.demo.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/docenti")
public class DocenteController {

    @Autowired
    DocenteService docenteService;

    @GetMapping
    public String redirectToLista() {
        return "redirect:/docenti/lista";
    }

    @GetMapping("/lista")
    public String list(Model model) {
        model.addAttribute("docenti", docenteService.findAll());
        return "list-docenti";
    }

    @GetMapping("/nuovo")
    public String showAdd(Model model) {
        model.addAttribute("docente", new Docente()); //serve a passare i dati alla JSP
        return "nuovo-docenti";
    }

    @PostMapping
    public String create(@ModelAttribute("docente") Docente docente, BindingResult br) {
        if (br.hasErrors()) return "nuovo-docenti";
        docenteService.save(docente);
        return "redirect:/docenti/lista";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model) {
        model.addAttribute("docente", docenteService.get(id));
        return "nuovo-docenti";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable Long id, @ModelAttribute("docente") Docente docente, BindingResult br) {
        if (br.hasErrors()) return "nuovo-docenti";
        docente.setId(id);
        docenteService.save(docente);
        return "redirect:/docenti/lista";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        docenteService.delete(id);
        return "redirect:/docenti/lista";

    }
}
