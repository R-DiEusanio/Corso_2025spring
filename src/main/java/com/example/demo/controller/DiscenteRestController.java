package com.example.demo.controller;

import com.example.demo.data.dto.DiscenteDTO;
import com.example.demo.entity.Discente;
import com.example.demo.mapper.DiscenteMapper;
import com.example.demo.service.DiscenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/discenti")
public class DiscenteRestController {

    @Autowired
    private DiscenteService discenteService;

    @Autowired
    private DiscenteMapper discenteMapper;

    @GetMapping
    public ResponseEntity<List<DiscenteDTO>> getAll() {
        List<Discente> discenti = discenteService.findAll();
        List<DiscenteDTO> dto = discenti.stream().map(discenteMapper::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscenteDTO> getById(@PathVariable Long id) {
        Discente discente = discenteService.get(id);
        return ResponseEntity.ok(discenteMapper.toDTO(discente));
    }

    @PostMapping
    public ResponseEntity<DiscenteDTO> createDiscente(@RequestBody DiscenteDTO dto) {
        Discente entity = discenteMapper.toEntity(dto);
        Discente salvato = discenteService.save(entity);
        return ResponseEntity.ok(discenteMapper.toDTO(salvato));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiscenteDTO> update(@PathVariable Long id, @RequestBody DiscenteDTO dto) {
        Discente esistente = discenteService.get(id);

        esistente.setNome(dto.getNome());
        esistente.setCognome(dto.getCognome());
        esistente.setMatricola(dto.getMatricola());
        esistente.setEta(dto.getEta());
        esistente.setCittaResidenza(dto.getCittaResidenza());

        Discente aggiornato = discenteService.save(esistente);
        return ResponseEntity.ok(discenteMapper.toDTO(aggiornato));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        discenteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/corso/{corsoId}")
    public ResponseEntity<List<DiscenteDTO>> getDiscentiByCodiceCorso(@PathVariable Long corsoId) {
        List<Discente> discenti = discenteService.findByCorsoId(corsoId);
        List<DiscenteDTO> dto = discenti.stream()
                .map(discenteMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dto);
    }

}
