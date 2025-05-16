package com.example.demo.service;
import com.example.demo.entity.Discente;
import com.example.demo.data.dto.DiscenteDTO;
import com.example.demo.repository.DiscenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscenteService {

    @Autowired
    private DiscenteRepository discenteRepository;

    @Autowired
    private ModelMapper modelMapper;

    private DiscenteDTO toDto(Discente discente) {
        return modelMapper.map(discente, DiscenteDTO.class);
    }

    private Discente toEntity(DiscenteDTO dto) {
        return modelMapper.map(dto, Discente.class);
    }

    public List<DiscenteDTO> findAll() {
        return discenteRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Discente get(Long id) {
        return discenteRepository.findById(id).orElseThrow();
    }

    public Discente save(Discente s) {
        return discenteRepository.save(s);
    }

    public void delete(long id) {
        discenteRepository.deleteById(id);
    }

    public List<DiscenteDTO> maggiorenni() {
        return discenteRepository.trovaTuttiMaggiorenni(30)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<DiscenteDTO> DiscentiOrdinatiPerNome() {
        return discenteRepository.DiscentiOrdinatiPerNome()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
