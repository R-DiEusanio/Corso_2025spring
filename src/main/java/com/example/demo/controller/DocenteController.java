package com.example.demo.controller;
import com.example.demo.entity.Docente;
import com.example.demo.service.DocenteService;
import com.example.demo.data.dto.DocenteDTO;
import com.example.demo.converter.DocenteConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Docente> docenti = docenteService.findAll();
        List<DocenteDTO> docentiDTO = docenti.stream()
                .map(DocenteConverter::toDTO)
                .collect(Collectors.toList());
        model.addAttribute("docenti", docentiDTO);
        return "list-docenti";
    }

    @GetMapping("/nuovo")
    public String showAdd(Model model) {
        model.addAttribute("docente", new Docente());
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
        Docente docente = docenteService.get(id);
        model.addAttribute("docente", docente);
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

    @GetMapping("/nome/{nome}")
    public ModelAndView mostraDocentiPerNome(@PathVariable String nome) {
        List<Docente> lista = docenteService.cercaNome(nome);
        List<DocenteDTO> listaDTO = lista.stream()
                .map(DocenteConverter::toDTO)
                .collect(Collectors.toList());
        ModelAndView mav = new ModelAndView("list-docenti");
        mav.addObject("docenti", listaDTO);
        return mav;
    }
}
