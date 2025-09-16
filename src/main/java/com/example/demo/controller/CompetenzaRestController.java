package com.example.demo.controller;

import com.example.demo.data.dto.CompetenzaDTO;
import com.example.demo.entity.Docente;
import com.example.demo.service.CompetenzaService;
import com.example.demo.repository.DocenteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/competenze")
public class CompetenzaRestController {

    private final CompetenzaService competenzaService;
    private final DocenteRepository docenteRepository;

    public CompetenzaRestController(CompetenzaService competenzaService, DocenteRepository docenteRepository) {
        this.competenzaService = competenzaService;
        this.docenteRepository = docenteRepository;
    }

    @GetMapping("/docenti")
    public List<Map<String, Object>> getDocentiConCompetenze() {
        List<Docente> docenti = docenteRepository.findAllByOrderByCognomeAsc();
        List<Map<String, Object>> result = new ArrayList<>();

        for (Docente d : docenti) {
            Map<String, Object> docenteMap = new HashMap<>();
            docenteMap.put("id", d.getId());
            docenteMap.put("nome", d.getNome());
            docenteMap.put("cognome", d.getCognome());
            docenteMap.put("competenze", competenzaService.getCompetenzeByDocente(d.getId()));
            result.add(docenteMap);
        }
        return result;
    }

    @PostMapping
    public CompetenzaDTO add(@RequestBody CompetenzaDTO dto) {
        return competenzaService.addCompetenza(dto);
    }

    @PutMapping("/{id}")
    public CompetenzaDTO update(@PathVariable Long id, @RequestBody CompetenzaDTO dto) {
        return competenzaService.updateCompetenza(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        competenzaService.deleteCompetenza(id);
    }
}
