package com.example.demo.mapper;
import com.example.demo.data.dto.CorsiDTO;
import com.example.demo.entity.Corsi;
import com.example.demo.entity.Discente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CorsiMapper {

    @Autowired
    private ModelMapper modelMapper;

    public CorsiDTO toDto(Corsi corso) {
        CorsiDTO dto = modelMapper.map(corso, CorsiDTO.class);

        if (corso.getDocente() != null) {
            dto.setDocenteNome(corso.getDocente().getNome() + " " + corso.getDocente().getCognome());
        }

        if (corso.getDiscenti() != null) {
            List<String> nomi = corso.getDiscenti().stream()
                    .map(d -> d.getNome() + " " + d.getCognome())
                    .collect(Collectors.toList());
            dto.setDiscentiNomi(nomi);
        }

        return dto;
    }

    public Corsi toEntity(CorsiDTO dto) {
        return modelMapper.map(dto, Corsi.class);
    }
}
