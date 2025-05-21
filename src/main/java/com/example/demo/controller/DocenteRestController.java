package com.example.demo.controller;

import com.example.demo.data.dto.DocenteDTO;
import com.example.demo.entity.Docente;
import com.example.demo.mapper.DocenteMapper;
import com.example.demo.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/docenti")
public class DocenteRestController {

    @Autowired
    private DocenteService docenteService;

    @Autowired
    private DocenteMapper docenteMapper;

    @GetMapping
    public ResponseEntity<List<DocenteDTO>> getAll() {
        List<Docente> docenti =docenteService.findAll();
        List<DocenteDTO> dto = docenti.stream().map(docenteMapper::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocenteDTO> getByid(@PathVariable Long id) {
        Docente docente = docenteService.get(id);
        return ResponseEntity.ok(docenteMapper.toDTO(docente));
    }

    @PostMapping
    public ResponseEntity<DocenteDTO> create(@RequestBody DocenteDTO dto) {
        Docente entity = docenteMapper.toEntity(dto);
        Docente salvato = docenteService.save(entity);
        return ResponseEntity.ok(docenteMapper.toDTO(salvato));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocenteDTO> update(@PathVariable Long id, @RequestBody DocenteDTO dto) {
        Docente esistente = docenteService.get(id);

        esistente.setNome(dto.getNome());
        esistente.setCognome(dto.getCognome());
        esistente.setDataNascita(dto.getDataNascita());

        Docente aggiornato = docenteService.save(esistente);
        return ResponseEntity.ok(docenteMapper.toDTO(aggiornato));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        docenteService.delete(id);
        return ResponseEntity.noContent().build();
    }

}