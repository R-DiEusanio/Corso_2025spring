package com.example.demo.mapper;
import com.example.demo.data.dto.DiscenteDTO;
import com.example.demo.entity.Discente;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface DiscenteMapper {

    @Mapping(target = "corsi", ignore = true)
    DiscenteDTO toDTO(Discente discente);

    @Mapping(target = "corsi", ignore = true)
    Discente toEntity(DiscenteDTO dto);

    @AfterMapping
    default void mapCorsi(Discente discente, @MappingTarget DiscenteDTO dto) {
        if (discente.getCorsi() != null) {
            dto.setCorsi(
                    discente.getCorsi().stream()
                            .map(c -> c.getNomeCorso())
                            .collect(Collectors.toList())
            );
        }
    }
}
