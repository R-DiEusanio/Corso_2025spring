package com.example.demo.controller;

import com.example.demo.data.dto.DocenteDTO;
import com.example.demo.entity.Docente;
import com.example.demo.mapper.DocenteMapper;
import com.example.demo.service.DocenteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/docenti")
public class DocenteRestController {

    private final DocenteService docenteService;
    private final DocenteMapper docenteMapper;

    public DocenteRestController(DocenteService docenteService, DocenteMapper docenteMapper) {
        this.docenteService = docenteService;
        this.docenteMapper = docenteMapper;
    }

    @GetMapping
    public ResponseEntity<List<DocenteDTO>> getAll() {
        try {
            List<Docente> docenti = docenteService.findAll();
            List<DocenteDTO> dto = docenti.stream()
                    .map(docenteMapper::toDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Errore durante il recupero dei docenti: " + e.getMessage()
            );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocenteDTO> getByid(@PathVariable Long id) {
        try {
            Docente docente = docenteService.get(id);
            return ResponseEntity.ok(docenteMapper.toDTO(docente));
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Errore durante il recupero del docente: " + e.getMessage()
            );
        }
    }

    @PostMapping
    public ResponseEntity<DocenteDTO> createDocente(@RequestBody DocenteDTO dto) {
        try {
            Docente entity = docenteMapper.toEntity(dto);
            Docente salvato = docenteService.save(entity);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(docenteMapper.toDTO(salvato));
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Errore durante la creazione del docente: " + e.getMessage()
            );
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocenteDTO> update(
            @PathVariable Long id,
            @RequestBody DocenteDTO dto) {
        try {
            Docente esistente = docenteService.get(id);
            
            esistente.setNome(dto.getNome());
            esistente.setCognome(dto.getCognome());
            esistente.setDataNascita(dto.getDataNascita());

            Docente aggiornato = docenteService.save(esistente);
            return ResponseEntity.ok(docenteMapper.toDTO(aggiornato));
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Errore durante l'aggiornamento del docente: " + e.getMessage()
            );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            docenteService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Errore durante l'eliminazione del docente: " + e.getMessage()
            );
        }
    }
}