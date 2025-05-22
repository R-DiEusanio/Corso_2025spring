package com.example.demo.controller;
import com.example.demo.data.dto.CorsiDTO;
import com.example.demo.data.dto.DiscenteDTO;
import com.example.demo.data.dto.DocenteDTO;
import com.example.demo.entity.Corsi;
import com.example.demo.entity.Discente;
import com.example.demo.entity.Docente;
import com.example.demo.mapper.CorsiMapper;
import com.example.demo.mapper.DocenteMapper;
import com.example.demo.service.CorsiService;
import com.example.demo.service.DiscenteService;
import com.example.demo.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/corsi")
public class CorsiRestController {

    @Autowired
    private CorsiService corsiService;

    @Autowired
    private CorsiMapper corsiMapper;

    @Autowired
    private DocenteService docenteService;

    @Autowired
    private DiscenteService discenteService;

    @GetMapping
    public ResponseEntity<List<CorsiDTO>> getAll() {
        List<Corsi> corsi = corsiService.findAll();
        List<CorsiDTO> dto = corsi.stream().map(corsiMapper::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CorsiDTO> getByid(@PathVariable Long id) {

        Corsi corsi = corsiService.get(id);
        return ResponseEntity.ok(corsiMapper.toDTO(corsi));

    }

    @PostMapping
    public ResponseEntity<CorsiDTO> create(@RequestBody CorsiDTO dto) {

        Docente docente = docenteService.findByNomeCompleto(dto.getDocenteNome())
                .orElseThrow(() -> new RuntimeException("docente non trovato"));

        List<Discente> discenti = dto.getDiscentiNomi().stream().map(nome -> discenteService.findByCompleto(nome).orElseThrow(()-> new RuntimeException("discente non trovato: " +nome))).collect(Collectors.toList());

        Corsi corsi = new Corsi();

        corsi.setNomeCorso(dto.getNomeCorso());
        corsi.setAnnoAccademico(dto.getAnnoAccademico());
        corsi.setDocente(docente);
        corsi.setDiscenti(discenti);

        return ResponseEntity.ok(corsiMapper.toDTO(corsiService.save(corsi)));

    }

    @PutMapping("/{id}")
    public ResponseEntity<CorsiDTO> update(@PathVariable Long id, @RequestBody CorsiDTO dto) {

        Corsi esistente = corsiService.get(id);

        Docente docente = docenteService.findByNomeCompleto(dto.getDocenteNome()).orElseThrow(()-> new RuntimeException("docente non trovato: " +dto.getDocenteNome()));

        List<Discente> discenti = dto.getDiscentiNomi().stream().map(nome->discenteService.findByCompleto(nome).orElseThrow(()-> new RuntimeException("docente non trovato: " +nome))).collect(Collectors.toList());

        esistente.setNomeCorso(dto.getNomeCorso());
        esistente.setAnnoAccademico(dto.getAnnoAccademico());
        esistente.setDocente(docente);
        esistente.setDiscenti(discenti);

        Corsi aggiornato = corsiService.save(esistente);
        return ResponseEntity.ok(corsiMapper.toDTO(aggiornato));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        corsiService.delete(id);
        return ResponseEntity.noContent().build();
    }


}