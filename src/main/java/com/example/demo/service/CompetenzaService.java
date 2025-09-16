package com.example.demo.service;

import com.example.demo.data.dto.CompetenzaDTO;
import com.example.demo.entity.Competenza;
import com.example.demo.entity.Docente;
import com.example.demo.mapper.CompetenzaMapper;
import com.example.demo.repository.CompetenzaRepository;
import com.example.demo.repository.DocenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetenzaService {

    private final CompetenzaRepository competenzaRepository;
    private final DocenteRepository docenteRepository;

    public CompetenzaService(CompetenzaRepository competenzaRepository, DocenteRepository docenteRepository) {
        this.competenzaRepository = competenzaRepository;
        this.docenteRepository = docenteRepository;
    }

    public List<CompetenzaDTO> getCompetenzeByDocente(Long docenteId) {
        return competenzaRepository.findByDocenteIdOrderByNomeAsc(docenteId)
                .stream()
                .map(CompetenzaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CompetenzaDTO addCompetenza(CompetenzaDTO dto) {
        Docente docente = docenteRepository.findById(dto.getDocenteId())
                .orElseThrow(() -> new RuntimeException("Docente non trovato"));
        Competenza competenza = CompetenzaMapper.toEntity(dto);
        competenza.setDocente(docente);
        return CompetenzaMapper.toDTO(competenzaRepository.save(competenza));
    }

    public CompetenzaDTO updateCompetenza(Long id, CompetenzaDTO dto) {
        Competenza competenza = competenzaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Competenza non trovata"));
        competenza.setNome(dto.getNome());
        competenza.setLivello(dto.getLivello());
        return CompetenzaMapper.toDTO(competenzaRepository.save(competenza));
    }

    public void deleteCompetenza(Long id) {
        competenzaRepository.deleteById(id);
    }
}
