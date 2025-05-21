package com.example.demo.service;
import com.example.demo.data.dto.DocenteDTO;
import com.example.demo.entity.Docente;
import com.example.demo.repository.DocenteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    @Autowired
    private ModelMapper modelMapper;

    private DocenteDTO toDto(Docente docente) {
        return modelMapper.map(docente, DocenteDTO.class);
    }

    private Docente toEntity(DocenteDTO dto) {
        return modelMapper.map(dto, Docente.class);
    }

    public List<DocenteDTO> findAll() {
        return docenteRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Docente get(Long id) {
        return docenteRepository.findById(id).orElseThrow();
    }

    public Docente save(Docente docente) {
        return docenteRepository.save(docente);
    }

    public void delete(Long id) {
        docenteRepository.deleteById(id);
    }

    public List<DocenteDTO> cercaNome(String nome) {
        return docenteRepository.trovaPerNome(nome)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
